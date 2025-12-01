FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/BackEnd-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
# Use apenas um CMD. Este abaixo define um limite de memória seguro para containers pequenos.
CMD ["java", "-Xmx512m", "-jar", "-Dserver.port=${PORT}", "app.jar"]