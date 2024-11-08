# Use official Maven image as the base image
FROM maven:3.8.4-openjdk-11-slim

# Set working directory
WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY src ./src

# Package the application
CMD ["mvn", "clean", "package"]