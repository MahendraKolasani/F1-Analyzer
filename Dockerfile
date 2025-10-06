FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw
COPY pom.xml .
COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN mkdir -p /data
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
