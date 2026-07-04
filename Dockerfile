FROM eclipse-temurin:21
LABEL mantainer="ricardokohlermk@gmail.com"
WORKDIR	/app
EXPOSE 8080
COPY target/imobiliaria-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]