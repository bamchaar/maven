FROM openjdk:8-alpine AS build  
EXPOSE 8080
WORKDIR /usr/app
COPY ./target/my-app-*.jar /usr/app 
CMD java -jar my-app-*.jar