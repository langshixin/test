FROM maven:latest

RUN mvn clean install -DskipTes

FROM openjdk:8-jdk

MAINTAINER langshixin

#WORKDIR /usr/local
#
#VOLUME /Users/langshixin/java/log1

ADD target/*.jar ./app.jar

CMD ["/bin/bash", "java -jar app.jar"]
