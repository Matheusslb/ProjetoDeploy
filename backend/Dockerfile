FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/BackEnd-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "-Dserver.port=${PORT}", "app.jar"]
CMD ["java", "-Xmx512m", "-jar", "-Dserver.port=${PORT}", "app.jar"]