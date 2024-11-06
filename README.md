# Aplicación E-commerce Ferran Monfort

## Descripción

El microservicio permite consultar los precios de los productos según las fechas y prioridades marcadas
en cada brand.


## Detalles de la aplicación

1. He generado los test correspondientes en la clase test: PriceRestControllerTest.java Se pueden lanzar con: mvn test

2. He expuesto con OpenApi el endpoint para hacer las consultas. El swagger UI disponible en: http://localhost:8080/swagger-ui/index.html

3. La base de datos H2 disponible en: http://localhost:8080/h2-console (con nombre, user y password indicados en el application.properties)

## Docker

He generado un Dockerfile y un docker compose que permiten dockerizar el microservicio.

Pasos:

1. Generar con Maven: mvn clean package
2. Lanzar el docker-compose con: docker-compose up -d
3. La aplicación queda disponible en el mismo puerto 8080.


## Comentarios sobre el codigo

1. He obtado por seprar las entidades del dominio de las entidades de infraestructura de base de datos (Price y PriceEntity)
para hacer visible la separación de responsabilidades (hexagonal). En una aplicación tan senzilla seguramente no hace falta
tanta segmentación y aprovechar la declaración de la entity de dominio para la comunicación con BBDD.

2. Los servicios y repositorios están anotados con las anotaciones especificas de spring. Para un mayor control acostumbro declarar 
los componentes en clases de configuración y crear beans con mayor control. Como la aplicación es pequeña he pensado que no era necesario.

3. Para la representación hexagonal (port/adapter), en este caso he obtado por declarar los puertos de entrada y salida
en application (pudiendo declararse en el dominio bajo el package ports). El puerto de entrada es la interface al servicio de applicación
para la consulta de precios (podría ir con una capa USECASES para una mayor segmentación de responsabilidades). El puerto de salida es el repositorio
para la comunicación a base de datos.

4. Los adapters (en infrastructure) para las comunicaciones externas tanto de REST como de persistencia.

5. Para una rápida implementación de la query he utilizado Spring Data JPA, ya se que no tengo un control total sobre las queries como
si trabajara directamente con JPA (o Hibernate) ORM.

6. Solo he declarado la entidad Price. Podría haber declarado Brand con una relación ManyToOne (las tiendas tendrán varios precios),
alguna entidad Currency (con una declaración de las posibles unidades monetarias)... etc. En este ejercicio no era necesario.

7. No he parseado las respuestas de error en un formato objeto json. Podría hacerse con un formato definido, pero devuelvo directamente un String con el mensaje de error.


