# --- Estágio 1: Build (Compilação) ---
FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /app
COPY . .
# Dá permissão de execução ao mvnw e compila o projeto ignorando testes para agilizar
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# --- Estágio 2: Runtime (Execução) ---
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# Copia o JAR gerado no estágio anterior (builder)
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Comando de inicialização com limite de memória
CMD ["java", "-Xmx512m", "-jar", "-Dserver.port=${PORT}", "app.jar"]