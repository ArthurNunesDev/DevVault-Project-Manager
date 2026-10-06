FROM maven:3.9.16-eclipse-temurin-21-alpine

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -B -DskipTests clean package

EXPOSE 8081

CMD ["sh", "-c", "java -jar target/*.jar"]
