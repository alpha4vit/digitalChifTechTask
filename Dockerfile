FROM maven:3.9.6-eclipse-temurin-21-alpine as build
WORKDIR /
COPY /src /src
COPY pom.xml /
RUN mvn clean package -Dmaven.test.skip

FROM openjdk:21-jdk-slim
WORKDIR /
COPY /src /src
COPY --from=build /target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]