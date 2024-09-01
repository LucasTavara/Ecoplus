FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/ecoplus-0.0.1-SNAPSHOT.jar ecoplus.jar
ENTRYPOINT ["java", "-jar", "ecoplus.jar"]