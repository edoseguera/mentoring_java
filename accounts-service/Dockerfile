FROM amazoncorretto:11-alpine-jdk

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} accounts-service.jar
ENTRYPOINT ["java", "-jar", "/accounts-service.jar"]