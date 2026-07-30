# Estágio de Build
FROM maven:3.8.8-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Estágio de Execução
FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

