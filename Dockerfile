FROM openjdk:8-alpine AS build  
EXPOSE 8080
COPY ./target/my-app-1.0-SNAPSHOT.jar /usr/app 
WORKDIR /usr/app

FROM gcr.io/distroless/java  

ENTRYPOINT ["java","-jar","my-app-1.0-SNAPSHOT.jar"]  