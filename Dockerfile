# Usa una imagen de Java como base
FROM openjdk:17

# Define el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY target/drug-man-0.0.1-SNAPSHOT.jar app.jar

# Expone los puertos necesarios (por ejemplo, el puerto 8080 para la API REST y el puerto 9090 para el WebSocket)
EXPOSE 80

# Comando para ejecutar la aplicación al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "/app/app.jar"]