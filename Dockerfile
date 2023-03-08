FROM openjdk:8-alpine AS build  
EXPOSE 8080
WORKDIR /usr/app
COPY ./target/my-app-1.0-SNAPSHOT.jar /usr/app 
ENTRYPOINT ["java","-jar","my-app-1.0-SNAPSHOT.jar"]  