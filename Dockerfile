# Usando uma imagem base do Java
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o arquivo JAR gerado pelo Maven/Gradle para o container
COPY target/back-lista-jogos.jar app.jar

# Porta exposta pelo container
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
