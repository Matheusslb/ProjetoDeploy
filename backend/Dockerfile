# --- Estágio 1: Compilação (Build) ---
FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /app

# Copia os arquivos de configuração do Maven
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Dá permissão de execução ao mvnw e baixa dependências (para cache)
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copia o código fonte e compila a aplicação
COPY src ./src
RUN ./mvnw clean package -DskipTests

# --- Estágio 2: Execução (Runtime) ---
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copia o JAR gerado no estágio anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta que o Railway usa
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]