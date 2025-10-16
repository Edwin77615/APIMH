# Etapa 1: construir el proyecto con Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: ejecutar la aplicación con un JDK liviano
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/api-facturacion-mh-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]