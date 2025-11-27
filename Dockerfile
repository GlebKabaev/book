FROM eclipse-temurin:8-jdk-alpine
WORKDIR /app
COPY target/book-0.0.1-SNAPSHOT.jar book.jar
ENTRYPOINT ["java", "-jar", "book.jar"]