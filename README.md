# quarkus4-jackson-native

Reproducer for a Jackson deserialization issue in native mode with Quarkus 4.

With Quarkus 4.0.0.Beta1 (Jackson 3), deserializing a simple POJO with an injected `ObjectMapper` fails in a native executable.
The same code works in JVM mode, and works in both JVM and native mode with Quarkus 3.40.1 (Jackson 2).

## The project

A minimal Quarkus application using `quarkus-rest` and `quarkus-jackson`:

- `JacksonPojo`: a POJO with two fields, `String name` and `boolean validity`, with getters but no setters and no explicit constructor. It is annotated with:
  - `@RegisterForReflection`
  - `@JsonIgnoreProperties(ignoreUnknown = true)`
  - `@JsonProperty("myname")` on the `name` field
- `JacksonResource`: a REST endpoint `GET /jackson` that injects an `ObjectMapper`, deserializes the following JSON into a `JacksonPojo`, logs the result and returns `OK`:

  ```json
  {"myname":"my name","validity":true}
  ```

  If the deserialization throws, the endpoint catches the exception, logs it at `ERROR` level and returns `KO: ` followed by the exception, so the error shows up directly in the test failure.

- `JacksonResourceTest` (`@QuarkusTest`, JVM mode) and `JacksonResourceIT` (`@QuarkusIntegrationTest`, native mode): both call `GET /jackson` and expect a `200` with body `OK`.

The `native` Maven profile builds the native executable in a container (`quarkus.native.container-build=true`), so no local GraalVM installation is needed, and builds a container image for it (`quarkus-container-image-docker`, `quarkus.container-image.build=true`). The integration tests run against that image.

## The issue

In native mode with Quarkus 4.0.0.Beta1, `GET /jackson` returns `KO` instead of `OK`. The call to `ObjectMapper.readValue` fails on the `boolean validity` field:

```
tools.jackson.databind.DatabindException: Problem deserializing property 'validity' (expected type: [simple type, class boolean]; actual type: `java.lang.Boolean`), problem: Can not set boolean field org.acme.JacksonPojo.validity to java.lang.Integer
 at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); byte offset: #UNKNOWN] (through reference chain: org.acme.JacksonPojo["validity"])
	at tools.jackson.databind.deser.SettableBeanProperty._throwAsJacksonE(SettableBeanProperty.java:656)
	at tools.jackson.databind.deser.impl.MethodProperty.deserializeAndSet(MethodProperty.java:134)
	at tools.jackson.databind.deser.bean.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:659)
	at tools.jackson.databind.deser.bean.BeanDeserializer.deserialize(BeanDeserializer.java:200)
	at tools.jackson.databind.deser.DeserializationContextExt.readRootValue(DeserializationContextExt.java:266)
	at tools.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:2639)
	at tools.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:1544)
	at org.acme.JacksonResource.jackson(JacksonResource.java:22)
```

The same endpoint returns `OK` in JVM mode.

Adding a setter for the `validity` field fixes the issue: with the setter, `GET /jackson` returns `OK` in native mode as well. The setter is present but commented out in `JacksonPojo`:

```java
// uncommenting this setter fixes the issue in native mode
//    public void setValidity(boolean validity) {
//        this.validity = validity;
//    }
```

## Reproducing the issue

Prerequisites: JDK 25 and a running Docker daemon.

Build the native executable and run the tests:

```shell script
./mvnw clean verify -Dnative
```

The JVM tests pass, the native integration test for `/jackson` fails, and the build ends in `BUILD FAILURE`. The exception is visible in the test failure:

```
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 -- in org.acme.GreetingResourceTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 -- in org.acme.JacksonResourceTest
...
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 -- in org.acme.GreetingResourceIT
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0 <<< FAILURE! -- in org.acme.JacksonResourceIT
...
[ERROR] Failures:
[ERROR]   JacksonResourceIT>JacksonResourceTest.testJacksonEndpoint:17 1 expectation failed.
Response body doesn't match expectation.
Expected: is "OK"
  Actual: KO: tools.jackson.databind.DatabindException: Problem deserializing property 'validity' (expected type: [simple type, class boolean]; actual type: `java.lang.Boolean`), problem: Can not set boolean field org.acme.JacksonPojo.validity to java.lang.Integer
 at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); byte offset: #UNKNOWN] (through reference chain: org.acme.JacksonPojo["validity"])

[ERROR] Tests run: 2, Failures: 1, Errors: 0, Skipped: 0
```

To get the full stack trace, run the container image produced by the build and call the endpoint. The image name is printed in the build log (`Built container image <user>/quarkus4-jackson-native:1.0.0-SNAPSHOT`):

```shell script
docker run --rm -p 8080:8080 <user>/quarkus4-jackson-native:1.0.0-SNAPSHOT
```

```shell script
curl http://localhost:8080/jackson
```

The response is `KO: tools.jackson.databind.DatabindException: ...`, and the exception is logged with its stack trace at `ERROR` level in the container logs (`unable to deserialize json`).

## Not reproducible with Quarkus 3.40.1

With Quarkus 3.40.1 (Jackson 2) and otherwise identical code, `GET /jackson` returns `OK` in both JVM and native mode.

To check this:

1. In `pom.xml`, change the Quarkus version:

   ```xml
   <quarkus.platform.version>3.40.1</quarkus.platform.version>
   ```

2. In `src/main/java/org/acme/JacksonResource.java`, switch the `ObjectMapper` import from the Jackson 3 API to the Jackson 2 API:

   ```java
   // remove
   import tools.jackson.databind.ObjectMapper;

   // add
   import com.fasterxml.jackson.databind.ObjectMapper;
   ```

   No other change is needed: the checked `JsonProcessingException` thrown by Jackson 2's `readValue` is handled by the existing `catch (Exception e)`, and the Jackson annotations used by `JacksonPojo` are in the `com.fasterxml.jackson.annotation` package in both versions.

3. Build the native executable and run the tests again:

   ```shell script
   ./mvnw clean verify -Dnative
   ```

   All tests pass, including the native ones, and the build ends in `BUILD SUCCESS`:

   ```
   [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 -- in org.acme.GreetingResourceTest
   [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 -- in org.acme.JacksonResourceTest
   ...
   [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 -- in org.acme.GreetingResourceIT
   [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 -- in org.acme.JacksonResourceIT
   ```

## Environment

The results above were obtained with:

- macOS on aarch64, Docker 28.3.0
- native builder image running Mandrel 25.0.4.1 (JDK 25.0.4.1+1-LTS)
