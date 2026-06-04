profile `it` cannot be used in integration tests when running in native

to reproduce, first verifies it works in jvm mode:
```
mvn clean verify -DskipITs=false
```

now do the same in native:
```
mvn clean verify -DskipITs=false -Dnative
```

the build fails on the IT with error:
```
[ERROR] Tests run: 2, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 15.09 s <<< FAILURE! -- in org.acme.GreetingResourceIT
[ERROR] org.acme.GreetingResourceIT.testFooEndpoint -- Time elapsed: 3.514 s <<< FAILURE!
java.lang.AssertionError: 
1 expectation failed.
Response body doesn't match expectation.
Expected: is "foo=it-bar"
  Actual: foo=bar
```

the docker command to tun the IT is:
```
2026-06-04 09:13:27,348 INFO  [io.quarkus.test.common.DefaultDockerContainerLauncher] (main) Executing "docker run --name quarkus-integration-test-qbHjz -i --rm -p 8081:8081 -p 8444:8444 --net=quarkus-integration-test-oVwhf --env QUARKUS_LOG_CATEGORY__IO_QUARKUS__LEVEL=INFO --env QUARKUS_HTTP_PORT=8081 --env QUARKUS_HTTP_SSL_PORT=8444 --env TEST_URL=http://localhost:${quarkus.http.test-port:8081} --env QUARKUS_PROFILE=it vsevel/code-with-quarkus:1.0.0-SNAPSHOT" 
```

so the `it` profile is set, which is good.
but for some reason, the properties in the `application-it.yaml` do not seem to be loaded.

we should pick `foo=it-bar` from that config file. 
it is as if this file is not present in the native binary in spite of `quarkus.native.resources.includes=application-it.properties`