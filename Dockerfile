
# ===== Build Stage =====
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy source files
COPY pom.xml .
COPY src ./src

# Build app without tests
RUN mvn clean package -DskipTests

# ===== Runtime Stage =====
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy final JAR from builder stage
COPY --from=builder /app/target/Proyecto-Tic-Tac-Toe-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
