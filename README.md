# getting-started

to reproduce execute: `mvn clean verify -DskipITs=false`
this is going to fail with: 
```
[ERROR] Errors: 
[ERROR]   GreetingResourceIT.testHelloEndpoint » Runtime java.lang.IllegalStateException: Unable to determine the status of the running process. See the above logs for details                                                                                                                           
[INFO]  
```

there is no visible log. to show it execute the full command:
``` 
java -Dquarkus.http.port=8081 -Dquarkus.http.ssl-port=8444 -Dtest.url=http://localhost:8081 -Dquarkus.log.file.path=./target/quarkus.log -Dquarkus.log.file.enabled=true -Dquarkus.log.category."io.quarkus".level=INFO -Dquarkus.profile=prod -jar ./target/quarkus-app/quarkus-run.jar
```

you should see:
``` 
17:30:09,067 ERROR [io.qua.run.Quarkus] Error running Quarkus: java.lang.ExceptionInInitializerError
        at java.base/jdk.internal.misc.Unsafe.allocateInstance(Native Method)
        at java.base/java.lang.invoke.DirectMethodHandle.allocateInstance(DirectMethodHandle.java:501)
        at io.quarkus.runtime.Quarkus.run(Quarkus.java:78)
        at io.quarkus.runtime.Quarkus.run(Quarkus.java:50)
        at io.quarkus.runtime.Quarkus.run(Quarkus.java:143)
        at io.quarkus.runner.GeneratedMain.main(Unknown Source)
        at io.quarkus.bootstrap.runner.QuarkusEntryPoint.doRun(QuarkusEntryPoint.java:69)
        at io.quarkus.bootstrap.runner.QuarkusEntryPoint.main(QuarkusEntryPoint.java:37)
Caused by: java.lang.RuntimeException: Failed to start quarkus
        at io.quarkus.runner.ApplicationImpl.<clinit>(Unknown Source)
        ... 8 more
Caused by: java.lang.NoClassDefFoundError: GreetingResource_Bean
        at io.quarkus.arc.setup.Default_ComponentsProvider_addBeans0.addBeans0(Unknown Source)
        at io.quarkus.arc.setup.Default_ComponentsProvider.getComponents(Unknown Source)
        at io.quarkus.arc.impl.ArcContainerImpl.<init>(ArcContainerImpl.java:137)
        at io.quarkus.arc.Arc.initialize(Arc.java:53)
        at io.quarkus.arc.runtime.ArcRecorder.initContainer(ArcRecorder.java:53)
        at io.quarkus.runner.recorded.ArcProcessor$initializeContainer643029769.deploy_0(Unknown Source)
        at io.quarkus.runner.recorded.ArcProcessor$initializeContainer643029769.deploy(Unknown Source)
        ... 9 more
Caused by: java.lang.ClassNotFoundException: GreetingResource_Bean
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
        at io.quarkus.bootstrap.runner.RunnerClassLoader.loadClass(RunnerClassLoader.java:136)
        at io.quarkus.bootstrap.runner.RunnerClassLoader.loadClass(RunnerClassLoader.java:87)
        ... 16 more
```

or simply execute `java -jar target/quarkus-app/quarkus-run.jar`, you will see the same error.

go to pom.xml and replace `3.31.0.CR1` with `3.30.6`, and execute the same command. the build should pass.