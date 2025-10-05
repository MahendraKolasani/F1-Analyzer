# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# 1. Copies the executable JAR
COPY --from=builder /app/target/f1-analyzer-1.0-SNAPSHOT.jar app.jar
# 2. Runs the executable JAR correctly
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080