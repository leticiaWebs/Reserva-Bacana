# Etapa de build com Maven e JDK 17
FROM maven:3.8.4-openjdk-17 AS build

# Copiar o código-fonte e o arquivo pom.xml para o contêiner
COPY src /app/src
COPY pom.xml /app

# Definir o diretório de trabalho
WORKDIR /app

# Executar a instalação e compilação com Maven
RUN mvn clean install

# Etapa de runtime com JDK 17
FROM openjdk:17-jdk-slim

# Copiar o artefato da etapa de build para a imagem final
COPY --from=build /app/target/reservarestaurante-0.0.1-SNAPSHOT.jar /app/app.jar

# Definir o diretório de trabalho
WORKDIR /app

# Expor a porta 8080
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]