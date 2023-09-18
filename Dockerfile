FROM eclipse-temurin:20-jdk-alpine

WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY gradle gradle

COPY gradlew .
COPY gradle/wrapper/gradle-wrapper.properties ./gradle/wrapper/

RUN chmod +x gradlew

COPY src src

RUN ./gradlew bootJar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/Rosa-0.0.1-SNAPSHOT.jar"]