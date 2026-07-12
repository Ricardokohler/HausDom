FROM postgres
LABEL maintainer="ricardokohlermk@gmail.com"
WORKDIR /app
EXPOSE 5432
COPY imobiliaria-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]