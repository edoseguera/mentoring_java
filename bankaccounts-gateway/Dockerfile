FROM amazoncorretto:11-alpine-jdk

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bankaccounts-gateway.jar
ENTRYPOINT ["java", "-jar", "/bankaccounts-gateway.jar"]