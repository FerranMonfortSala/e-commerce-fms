# Usar una imagen base de OpenJDK 21
FROM amazoncorretto:21

# Establecer un directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el JAR generado a la imagen Docker
COPY target/*.jar app.jar

# Exponer el puerto 8080 (puerto típico de Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
