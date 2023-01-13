FROM openjdk:8-jdk-alpine

COPY build/libs /opt/spring-boot

### Set Environment
ENV SERVER_HOME /opt/spring-boot

### Open Ports
EXPOSE 9012

### Start instance
ENTRYPOINT ["java", "-jar", "-Dfile.encoding=UTF-8", "/opt/spring-boot/demo-0.0.1-SNAPSHOT.jar"]