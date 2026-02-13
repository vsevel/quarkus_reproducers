this has been tested on macos, with quarkus `3.32.0.CR1` and jdk 25.
I have a similar behavior if I run a build inside container `registry.access.redhat.com/ubi9/openjdk-25:1.24`
execute:
```
./exec.sh
```
you should see:
```
2026-02-13 11:54:25,323 INFO  [io.quarkus.test.common.DefaultJarLauncher] (main) AOT file '/Users/vsevel/dev/github/vsevel-quarkus_reproducers/target/quarkus-app/app.aot' created
```
now execute:
```
SLEEP=20000 ./exec.sh
```
the script fails with:
```
!!!!!!!!!!!!!!! Error: AOT file missing!
```

to test in a container, execute:
```
docker run -it --rm -v .:/workspace -w /workspace registry.access.redha
t.com/ubi9/openjdk-25:1.24 sh
````

then:
```
./exec.sh
```
and
```
SLEEP=20000 ./exec.sh
```