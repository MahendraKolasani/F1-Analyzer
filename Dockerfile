FROM openjdk:19-jdk AS build
WORKDIR /app

COPY pom.xml .
COPY src src

RUN mvn clean package -DskipTests

FROM openjdk:19-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080