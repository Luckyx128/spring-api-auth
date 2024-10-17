# Usando uma imagem base do Java
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o arquivo JAR gerado pelo Maven/Gradle para o container
COPY target/lista-jogos-api-0.5..jar lista-jogos-api-0.5..jar

# Porta exposta pelo container
EXPOSE 9090

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "lista-jogos-api-0.5..jar"]
