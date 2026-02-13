set -e

mvn clean verify -DskipITs=false
cat target/quarkus.log | grep sleep
[ -f "target/quarkus-app/app.aot" ] || { echo "!!!!!!!!!!!!!!! Error: AOT file missing!"; exit 1; }

