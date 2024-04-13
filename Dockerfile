FROM openjdk:17-jdk-alpine

# Set the working directory to /{rootfolder}/docker
WORKDIR /{rootfolder}/docker

# Expose port 9090
EXPOSE 9090

# Copy the JAR file from the build context into the container
ARG JAR_FILE
COPY ${JAR_FILE} app.jar

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "/{rootfolder}/docker/app.jar"]
