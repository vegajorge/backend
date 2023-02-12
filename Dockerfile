FROM amazoncorretto:8-alpine-jdk 
MAINTAINER JLV 
COPY target/JLV-0.0.1-SNAPSHOT.jar jlv-app.jar 
ENTRYPOINT ["java","-jar","/jlv-app.jar"]
