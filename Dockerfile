FROM amazoncorretto:11-alpine-jdk
MAINTAINER MLB
COPY target/backend-0.0.1-SNAPSHOT.jar mlb-app.jar
ENTRYPOINT ["java","-jar","/mlb-app.jar"]