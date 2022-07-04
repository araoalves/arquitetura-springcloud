FROM openjdk:11
COPY target/api-gateway.jar api-gateway.jar
EXPOSE 5556
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]