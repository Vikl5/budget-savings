# Start with a base image that has Java 17 (or your app's Java version)
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set the working directory
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the project with production profile (minimizes frontend dependencies)
RUN mvn clean package -Pproduction -DskipTests

# ---- Stage 2: Create a minimal runtime image ----
FROM eclipse-temurin:21-jre AS runtime

# Set working directory
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]