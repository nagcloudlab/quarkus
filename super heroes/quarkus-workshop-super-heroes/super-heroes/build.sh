
export ORG=nagabhushanamn
cd rest-hero
docker build -f src/main/docker/Dockerfile.jvm -t $ORG/quarkus-workshop-hero .
cd ..
cd rest-villain
docker build -f src/main/docker/Dockerfile.jvm -t $ORG/quarkus-workshop-villain .
cd ..
cd rest-fight
docker build -f src/main/docker/Dockerfile.jvm -t $ORG/quarkus-workshop-fight .
cd ..
cd event-statistics
docker build -f src/main/docker/Dockerfile.jvm -t $ORG/quarkus-workshop-stats .