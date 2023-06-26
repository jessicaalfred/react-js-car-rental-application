FROM openjdk:11-jre-slim

# Copy the packaged jar file into our docker image
COPY maven/*.jar /app.jar

EXPOSE 8080

# Set the startup command to execute the jar
CMD ["java", "-jar", "/app.jar"]