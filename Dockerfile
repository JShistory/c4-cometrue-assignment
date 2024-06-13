FROM openjdk:17-alpine
LABEL authors="godpo"

ARG JAR_FILE=/build/libs/assignment-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /kjs.jar

ENTRYPOINT ["java", "-jar", "/kjs.jar"]

