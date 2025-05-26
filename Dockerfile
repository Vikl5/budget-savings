# Start with a base image that has Java 17 (or your app's Java version)
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline -B
COPY src ./src

RUN ./mvnw package -DskipTests

EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/budgetsavings-0.0.1-SNAPSHOT.jar"]
