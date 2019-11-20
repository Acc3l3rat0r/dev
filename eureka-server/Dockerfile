FROM openjdk:12-alpine
WORKDIR /app
COPY build/libs/eureka-server-0.1.jar ./
ENTRYPOINT ["java", "-jar", "/app/eureka-server-0.1.jar"]