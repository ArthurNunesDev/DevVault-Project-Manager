FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY . .

RUN chmod +x mvnw && ./mvnw -DskipTests clean package

EXPOSE 8081

CMD ["sh", "-c", "java -jar target/*.jar"]