FROM openjdk:12-alpine
WORKDIR /app
COPY build/libs/zuul-gateway-0.1.jar ./
ENTRYPOINT ["java", "-jar", "/app/zuul-gateway-0.1.jar"]