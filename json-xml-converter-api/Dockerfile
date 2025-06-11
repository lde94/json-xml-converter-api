# Build Stage
FROM maven:3.9-eclipse-temurin-21 AS build

LABEL authors="Ludvig Ekstam"

WORKDIR /app

# Copy the entire project and build the jar file
COPY . .

# Run Maven build
RUN mvn clean package -DskipTests

# Runtime Stage
FROM openjdk:21-jdk-slim AS runtime

WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/json-xml-converter-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]