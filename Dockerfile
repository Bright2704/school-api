FROM openjdk:19-jdk-alpine
EXPOSE 8081
ADD ./target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
