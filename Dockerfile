FROM openjdk:21-jdk
WORKDIR /app/ecoplus
COPY target/ecoplus-0.0.1-SNAPSHOT.jar ecoplus.jar
ENTRYPOINT ["java","-jar", "ecoplus.jar"]