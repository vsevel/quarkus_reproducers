# compose-base-kafka

```
docker compose -f compose-devservices.yml up
mvn quarkus:dev
```

you should see:
```
acBook-Air:vsevel-quarkus_reproducers vsevel$ mvn quarkus:dev
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< org.acme:compose-base-kafka >---------------------
[INFO] Building compose-base-kafka 1.0.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- quarkus:3.23.2:dev (default-cli) @ compose-base-kafka ---
[INFO] Invoking resources:3.3.1:resources (default-resources) @ compose-base-kafka
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Invoking quarkus:3.23.2:generate-code (default) @ compose-base-kafka
[INFO] Invoking compiler:3.14.0:compile (default-compile) @ compose-base-kafka
[INFO] Nothing to compile - all classes are up to date.
[INFO] Invoking resources:3.3.1:testResources (default-testResources) @ compose-base-kafka
[INFO] skip non existing resourceDirectory /Users/vsevel/dev/github/vsevel-quarkus_reproducers/src/test/resources
[INFO] Invoking quarkus:3.23.2:generate-code-tests (default) @ compose-base-kafka
[INFO] Invoking compiler:3.14.0:testCompile (default-testCompile) @ compose-base-kafka
[INFO] Nothing to compile - all classes are up to date.
Listening for transport dt_socket at address: 5005





--
Compose Dev Services Starting: 2025-06-10 12:06:56,397 INFO  [io.qua.dev.dep.com.ComposeProject] (build-92) Waiting for service apicurio to be ready
Tests paused
Press [e] to edit command line args (currently ''), [r] to resume testing, [o] Toggle test output, [:] for the terminal, [h] for more options>






















--
Compose Dev Services Starting: 2025-06-10 12:06:56,432 INFO  [io.qua.dev.dep.com.ComposeProject] (build-92) Service apicurio not ready, logs: Starting the Java application using /opt/jboss/container/java/run/run-java.sh ...INFO exec  java -Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager -javaagent:/usr/share/java/jolokia-jvm-agent/jolokia-jvm.jar=config=/opt/jboss/container/jolokia/etc/jolokia.properties -XX:MaxRAMPercentage=50.0 -XX:+UseParallelGC -XX:MinHeapFreeRatio=10 -XX:MaxHeapFreeRatio=20 -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -XX:+ExitOnOutOfMemoryError -cp "." -jar /deployments/apicurio-registry-app-2.4.2.Final-runner.jar WARNING: An illegal reflective access operation has occurredWARNING: Illegal reflective access by org.jolokia.util.ClassUtil (file:/usr/share/java/jolokia-jvm-agent/jolokia-jvm.jar) to constructor sun.security.x509.X500Name(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)WARNING: Please consider reporting this to the maintainers of org.jolokia.util.ClassUtilWARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operationsWARNING: All illegal access operations will be denied in a future releaseI> No access restrictor found, access to any MBean is allowedJolokia: Agent started with URL https://172.19.0.2:8778/jolokia/SLF4J: Class path contains multiple SLF4J bindings.SLF4J: Found binding in [jar:file:/deployments/lib/org.jboss.slf4j.slf4j-jboss-logging-1.2.1.Final.jar!/org/slf4j/impl/StaticLoggerBinder.class]SLF4J: Found binding in [jar:file:/deployments/lib/org.jboss.slf4j.slf4j-jboss-logmanager-1.2.0.Final.jar!/org/slf4j/impl/StaticLoggerBinder.class]SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.SLF4J: Actual binding is of type [org.jboss.slf4j.JBossLoggerFactory]__  ____  __  _____   ___  __ ____  ______  --/ __ \/ / / / _ | / _ \/ //_/ / / / __/  -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   --\___\_\____/_/ |_/_/|_/_/|_|\____/___/   2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.RegistryStorageProducer] (main) Using RegistryStore: io.apicurio.registry.storage.impl.sql.InMemoryRegistryStorage_ClientProxy2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.AbstractSqlRegistryStorage] (main) SqlRegistryStorage constructed successfully.  JDBC URL: jdbc:h2:mem:registry_db2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.AbstractSqlRegistryStorage] (main) Checking to see if the DB is initialized.2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.2025-06-10 12:06:55,717 INFO  [org.tes.uti.ImageNameSubstitutor] (build-31) Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2025-06-10 12:06:55,721 INFO  [org.tes.DockerClientFactory] (build-31) Checking the system...-06-10 10:06:34 INFO <> [io
2025-06-10 12:06:55,722 INFO  [org.tes.DockerClientFactory] (build-31) ✔︎ Docker server version should be at least 1.6.01
2025-06-10 12:06:56,397 INFO  [io.qua.dev.dep.com.ComposeProject] (build-92) Waiting for service apicurio to be ready202
2025-06-10 12:06:56,432 INFO  [io.qua.dev.dep.com.ComposeProject] (build-92) Service apicurio not ready, logs: Starting the Java application using /opt/jboss/container/java/run/run-java.sh ...g] (main) apicurio-registry-app 2.4.2.Final on J
INFO exec  java -Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager -javaagent:/usr/share/java/jolokia-jvm-agent/jolokia-jvm.jar=config=/opt/jboss/container/jolokia/etc/jolokia.properties -XX:MaxRAMPercentage=50.0 -XX:+UseParallelGC -XX:MinHeapFreeRatio=10 -XX:MaxHeapFreeRatio=20 -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -XX:+ExitOnOutOfMemoryError -cp "." -jar /deployments/apicurio-registry-app-2.4.2.Final-runner.jar ault-tolerance
WARNING: An illegal reflective access operation has occurred(build-31) Connected to docker: 
WARNING: Illegal reflective access by org.jolokia.util.ClassUtil (file:/usr/share/java/jolokia-jvm-agent/jolokia-jvm.jar) to constructor sun.security.x509.X500Name(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String) Desktop
WARNING: Please consider reporting this to the maintainers of org.jolokia.util.ClassUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
I> No access restrictor found, access to any MBean is allowed
Jolokia: Agent started with URL https://172.19.0.2:8778/jolokia/
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/deployments/lib/org.jboss.slf4j.slf4j-jboss-logging-1.2.1.Final.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/deployments/lib/org.jboss.slf4j.slf4j-jboss-logmanager-1.2.0.Final.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.jboss.slf4j.JBossLoggerFactory]
__  ____  __  _____   ___  __ ____  ______ 
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/ 
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/   
2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.RegistryStorageProducer] (main) Using RegistryStore: io.apicurio.registry.storage.impl.sql.InMemoryRegistryStorage_ClientProxy
2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.AbstractSqlRegistryStorage] (main) SqlRegistryStorage constructed successfully.  JDBC URL: jdbc:h2:mem:registry_db
2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.AbstractSqlRegistryStorage] (main) Checking to see if the DB is initialized.
2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.AbstractSqlRegistryStorage] (main) Database not initialized.
2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.AbstractSqlRegistryStorage] (main) Initializing the Apicurio Registry database.
2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.AbstractSqlRegistryStorage] (main)   Database type: h2
2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.AbstractSqlRegistryStorage] (main) Checking to see if the DB is up-to-date.
2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.AbstractSqlRegistryStorage] (main) Build's DB version is 12
2025-06-10 10:06:34 INFO <> [io.apicurio.registry.storage.impl.sql.InMemoryRegistryStorage] (main) Using In Memory (H2) SQL storage.
2025-06-10 10:06:35 INFO <_> [io.quarkus.bootstrap.runner.Timing] (main) apicurio-registry-app 2.4.2.Final on JVM (powered by Quarkus 2.16.4.Final) started in 0.936s. Listening on: http://0.0.0.0:8080
2025-06-10 10:06:35 INFO <_> [io.quarkus.bootstrap.runner.Timing] (main) Profile prod activated. 
2025-06-10 12:06:56,448 INFO  [io.qua.dep.dev.IsolatedDevModeMain] (main) Attempting to start live reload endpoint to recover from previous Quarkus startup failure
2025-06-10 12:06:56,676 ERROR [io.qua.dep.dev.IsolatedDevModeMain] (main) Failed to start quarkus: java.lang.RuntimeException: io.quarkus.builder.BuildException: Build failure: Build failed due to errors
        [error]: Build step io.quarkus.devservices.deployment.compose.ComposeDevServicesProcessor#config threw an exception: java.util.concurrent.CompletionException: java.lang.RuntimeException: java.lang.IllegalArgumentException: Requested port (8443) is not mapped
        at java.base/java.util.concurrent.CompletableFuture.encodeThrowable(CompletableFuture.java:315)
        at java.base/java.util.concurrent.CompletableFuture.completeThrowable(CompletableFuture.java:320)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1807)
        at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
        at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2651)
        at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2630)
        at org.jboss.threads.EnhancedQueueExecutor.runThreadBody(EnhancedQueueExecutor.java:1622)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1589)
        at java.base/java.lang.Thread.run(Thread.java:1583)
        at org.jboss.threads.JBossThread.run(JBossThread.java:501)
Caused by: java.lang.RuntimeException: java.lang.IllegalArgumentException: Requested port (8443) is not mapped
        at org.rnorth.ducttape.timeouts.Timeouts.callFuture(Timeouts.java:68)
        at org.rnorth.ducttape.timeouts.Timeouts.doWithTimeout(Timeouts.java:60)
        at org.testcontainers.containers.wait.strategy.WaitAllStrategy.waitUntilReady(WaitAllStrategy.java:54)
        at io.quarkus.devservices.deployment.compose.ComposeProject.waitUntilReady(ComposeProject.java:236)
        at io.quarkus.devservices.deployment.compose.ComposeProject.lambda$waitOnThread$7(ComposeProject.java:226)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804)
        ... 7 more
Caused by: java.lang.IllegalArgumentException: Requested port (8443) is not mapped
        at org.testcontainers.containers.ContainerState.getMappedPort(ContainerState.java:175)
        at org.testcontainers.containers.wait.strategy.HostPortWaitStrategy.lambda$getInternalPorts$4(HostPortWaitStrategy.java:123)
        at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
        at java.base/java.util.AbstractList$RandomAccessSpliterator.forEachRemaining(AbstractList.java:722)
        at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        at org.testcontainers.containers.wait.strategy.HostPortWaitStrategy.getInternalPorts(HostPortWaitStrategy.java:124)
        at org.testcontainers.containers.wait.strategy.HostPortWaitStrategy.waitUntilReady(HostPortWaitStrategy.java:56)
        at org.testcontainers.containers.wait.strategy.AbstractWaitStrategy.waitUntilReady(AbstractWaitStrategy.java:52)
        at org.testcontainers.containers.wait.strategy.WaitAllStrategy.waitUntilNestedStrategiesAreReady(WaitAllStrategy.java:66)
        at org.testcontainers.containers.wait.strategy.WaitAllStrategy.lambda$waitUntilReady$0(WaitAllStrategy.java:58)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
        at java.base/java.lang.Thread.run(Thread.java:1583)

        at io.quarkus.runner.bootstrap.AugmentActionImpl.runAugment(AugmentActionImpl.java:372)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.createInitialRuntimeApplication(AugmentActionImpl.java:289)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.createInitialRuntimeApplication(AugmentActionImpl.java:61)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.firstStart(IsolatedDevModeMain.java:89)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.accept(IsolatedDevModeMain.java:432)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.accept(IsolatedDevModeMain.java:55)
        at io.quarkus.bootstrap.app.CuratedApplication.runInCl(CuratedApplication.java:143)
        at io.quarkus.bootstrap.app.CuratedApplication.runInAugmentClassLoader(CuratedApplication.java:98)
        at io.quarkus.deployment.dev.DevModeMain.start(DevModeMain.java:107)
        at io.quarkus.deployment.dev.DevModeMain.main(DevModeMain.java:70)
Caused by: io.quarkus.builder.BuildException: Build failure: Build failed due to errors
        [error]: Build step io.quarkus.devservices.deployment.compose.ComposeDevServicesProcessor#config threw an exception: java.util.concurrent.CompletionException: java.lang.RuntimeException: java.lang.IllegalArgumentException: Requested port (8443) is not mapped
        at java.base/java.util.concurrent.CompletableFuture.encodeThrowable(CompletableFuture.java:315)
        at java.base/java.util.concurrent.CompletableFuture.completeThrowable(CompletableFuture.java:320)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1807)
        at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
        at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2651)
        at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2630)
        at org.jboss.threads.EnhancedQueueExecutor.runThreadBody(EnhancedQueueExecutor.java:1622)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1589)
        at java.base/java.lang.Thread.run(Thread.java:1583)
        at org.jboss.threads.JBossThread.run(JBossThread.java:501)
Caused by: java.lang.RuntimeException: java.lang.IllegalArgumentException: Requested port (8443) is not mapped
        at org.rnorth.ducttape.timeouts.Timeouts.callFuture(Timeouts.java:68)
        at org.rnorth.ducttape.timeouts.Timeouts.doWithTimeout(Timeouts.java:60)
        at org.testcontainers.containers.wait.strategy.WaitAllStrategy.waitUntilReady(WaitAllStrategy.java:54)
        at io.quarkus.devservices.deployment.compose.ComposeProject.waitUntilReady(ComposeProject.java:236)
        at io.quarkus.devservices.deployment.compose.ComposeProject.lambda$waitOnThread$7(ComposeProject.java:226)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804)
        ... 7 more
Caused by: java.lang.IllegalArgumentException: Requested port (8443) is not mapped
        at org.testcontainers.containers.ContainerState.getMappedPort(ContainerState.java:175)
        at org.testcontainers.containers.wait.strategy.HostPortWaitStrategy.lambda$getInternalPorts$4(HostPortWaitStrategy.java:123)
        at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
        at java.base/java.util.AbstractList$RandomAccessSpliterator.forEachRemaining(AbstractList.java:722)
        at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        at org.testcontainers.containers.wait.strategy.HostPortWaitStrategy.getInternalPorts(HostPortWaitStrategy.java:124)
        at org.testcontainers.containers.wait.strategy.HostPortWaitStrategy.waitUntilReady(HostPortWaitStrategy.java:56)
        at org.testcontainers.containers.wait.strategy.AbstractWaitStrategy.waitUntilReady(AbstractWaitStrategy.java:52)
        at org.testcontainers.containers.wait.strategy.WaitAllStrategy.ilNestedStrategiesAreReady(WaitAllStrategy.java:66)
        at org.testcontainers.containers.wait.strategy.WaitAllStrategy.lambda$waitUntilReady$0(WaitAllStrategy.java:58)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
        at java.base/java.lang.Thread.run(Thread.java:1583)

        at io.quarkus.builder.Execution.run(Execution.java:122)
        at io.quarkus.builder.BuildExecutionBuilder.execute(BuildExecutionBuilder.java:78)
        at io.quarkus.deployment.QuarkusAugmentor.run(QuarkusAugmentor.java:161)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.runAugment(AugmentActionImpl.java:368)
        ... 9 more
Caused by: java.util.concurrent.CompletionException: java.lang.RuntimeException: java.lang.IllegalArgumentException: Requested port (8443) is not mapped
        at java.base/java.util.concurrent.CompletableFuture.encodeThrowable(CompletableFuture.java:315)
        at java.base/java.util.concurrent.CompletableFuture.completeThrowable(CompletableFuture.java:320)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1807)
        at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
        at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2651)
        at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2630)
        at org.jboss.threads.EnhancedQueueExecutor.runThreadBody(EnhancedQueueExecutor.java:1622)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1589)
        at java.base/java.lang.Thread.run(Thread.java:1583)
        at org.jboss.threads.JBossThread.run(JBossThread.java:501)
Caused by: java.lang.RuntimeException: java.lang.IllegalArgumentException: Requested port (8443) is not mapped
        at org.rnorth.ducttape.timeouts.Timeouts.callFuture(Timeouts.java:68)
        at org.rnorth.ducttape.timeouts.Timeouts.doWithTimeout(Timeouts.java:60)
        at org.testcontainers.containers.wait.strategy.WaitAllStrategy.waitUntilReady(WaitAllStrategy.java:54)
        at io.quarkus.devservices.deployment.compose.ComposeProject.waitUntilReady(ComposeProject.java:236)
        at io.quarkus.devservices.deployment.compose.ComposeProject.lambda$waitOnThread$7(ComposeProject.java:226)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804)
        ... 7 more
Caused by: java.lang.IllegalArgumentException: Requested port (8443) is not mapped
        at org.testcontainers.containers.ContainerState.getMappedPort(ContainerState.java:175)
        at org.testcontainers.containers.wait.strategy.HostPortWaitStrategy.lambda$getInternalPorts$4(HostPortWaitStrategy.java:123)
        at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
        at java.base/java.util.AbstractList$RandomAccessSpliterator.forEachRemaining(AbstractList.java:722)
        at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        at org.testcontainers.containers.wait.strategy.HostPortWaitStrategy.getInternalPorts(HostPortWaitStrategy.java:124)
        at org.testcontainers.containers.wait.strategy.HostPortWaitStrategy.waitUntilReady(HostPortWaitStrategy.java:56)
        at org.testcontainers.containers.wait.strategy.AbstractWaitStrategy.waitUntilReady(AbstractWaitStrategy.java:52)
        at org.testcontainers.containers.wait.strategy.WaitAllStrategy.waitUntilNestedStrategiesAreReady(WaitAllStrategy.java:66)
        at org.testcontainers.containers.wait.strategy.WaitAllStrategy.lambda$waitUntilReady$0(WaitAllStrategy.java:58)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
        at java.base/java.lang.Thread.run(Thread.java:1583)



--
Tests paused
Press [e] to edit command line args (currently ''), [r] to resume testing, [o] Toggle test output, [:] for the terminal, [h] for more options>
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  14.876 s
[INFO] Finished at: 2025-06-10T12:07:01+02:00
[INFO] ------------------------------------------------------------------------
MacBook-Air:vsevel-quarkus_reproducers vsevel$ 
MacBook-Air:vsevel-quarkus_reproducers vsevel$ 
```