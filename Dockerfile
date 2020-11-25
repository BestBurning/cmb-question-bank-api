FROM openjdk:11-jre
MAINTAINER Shea<zhushuai026@gmail.com>

VOLUME /tmp
EXPOSE 8081

ARG JAR_FILE
ADD target/${JAR_FILE} /root/app.jar
ENTRYPOINT ["java", "-jar", "/root/app.jar"]