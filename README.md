# quarkus_4_beta2_cxf

Reproducer: Quarkus CXF `wsdl2java` code generation fails with Quarkus `4.0.0.Beta2`.

## Setup

- Quarkus platform `4.0.0.Beta2` (`io.quarkus.platform:quarkus-bom` + `io.quarkus.platform:quarkus-cxf-bom`)
- `io.quarkiverse.cxf:quarkus-cxf`
- A WSDL in `src/main/resources/wsdl/CalculatorService.wsdl`
- `quarkus.cxf.codegen.wsdl2java.includes=wsdl/*.wsdl` in `application.properties`

## Steps to reproduce

```shell script
mvn clean package -DskipTests
```

## Actual result

```
[INFO] --- quarkus:4.0.0.Beta2:generate-code (default-generate-code) @ quarkus_4_beta2_cxf ---
[ERROR] BUILD FAILURE
[ERROR] Failed to execute goal io.quarkus.platform:quarkus-maven-plugin:4.0.0.Beta2:generate-code (default-generate-code) on project quarkus_4_beta2_cxf: Quarkus code generation phase has failed: InvocationTargetException: 'org.eclipse.microprofile.config.Config io.quarkus.deployment.CodeGenContext.config()' -> [Help 1]
```

## Expected result

The build succeeds and `wsdl2java` generates the Java classes for the WSDL.

## Analysis

- [quarkusio/quarkus#57841](https://github.com/quarkusio/quarkus/pull/57841) changed `CodeGenContext.config()`.
- [`Wsdl2JavaCodeGen.trigger()`](https://github.com/quarkiverse/quarkus-cxf/blob/main/extensions/core/deployment/src/main/java/io/quarkiverse/cxf/deployment/codegen/Wsdl2JavaCodeGen.java#L74-L75) calls `context.config()`, so a QCXF build compiled against the old signature fails at runtime (the message format suggests a `NoSuchMethodError` wrapped in `InvocationTargetException`).
- `mvn dependency:tree` shows that the platform `io.quarkus.platform:quarkus-cxf-bom:4.0.0.Beta2` resolves:

  ```
  io.quarkus:quarkus-core:jar:4.0.0.Beta2
  io.quarkiverse.cxf:quarkus-cxf:jar:4.0.0.Beta1
  ```

  i.e. the platform pins QCXF `4.0.0.Beta1` (built against Quarkus before #57841), not QCXF `4.0.0.Beta2`.
  This would explain why QCXF's own upgrade to Quarkus `4.0.0.Beta2`
  ([quarkiverse/quarkus-cxf#2382](https://github.com/quarkiverse/quarkus-cxf/pull/2382)) was green.

## Workaround (verified)

Importing `io.quarkiverse.cxf:quarkus-cxf-bom:4.0.0.Beta2` instead of the platform `quarkus-cxf-bom` fixes the build
(`quarkus-cxf` resolves to `4.0.0.Beta2`, `wsdl2java` runs and generates the classes):

```shell script
mvn clean package -DskipTests -Dquarkus-cxf.bom.group-id=io.quarkiverse.cxf -Dquarkus-cxf.bom.version=4.0.0.Beta2
```

So the problem is the QCXF version aligned in the Quarkus platform `4.0.0.Beta2`, not QCXF `4.0.0.Beta2` itself.
