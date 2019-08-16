FROM openjdk:8u151-jdk-alpine
MAINTAINER Andrey Burmagin "RuS.Ghost@yandex.ru"

EXPOSE 8080

WORKDIR /app

COPY *.jar application.jar
CMD ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/app/application.jar"]