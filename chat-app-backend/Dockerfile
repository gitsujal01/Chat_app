#Java Base image
FROM openjdk:17-jdk-slim

#Jar File
COPY target/chat-app-backend-0.0.1-SNAPSHOT.jar app.jar

#Springboot default port
EXPOSE 8080

#Entrypoint
ENTRYPOINT ["java", "-jar", "/app.jar"]