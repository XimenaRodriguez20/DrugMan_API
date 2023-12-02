# Usa una imagen de Java como base
FROM openjdk:17

# Define el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY target/drug-man-0.0.1-SNAPSHOT.jar app.jar

# Expone los puertos necesarios en este caso el 80
EXPOSE 80

# Comando para ejecutar la aplicación al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "/app/app.jar"]