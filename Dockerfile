FROM maven:3.5-jdk-8-alpine
RUN mkdir /testGatling
WORKDIR /testGatling
COPY /src /testGatling 
RUN mvn gatling:test