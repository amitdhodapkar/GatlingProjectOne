FROM maven:3.5-jdk-8-alpine
RUN mkdir /testGatling
WORKDIR /testGatling
COPY // /testGatling
ENV PORT=4200
RUN mvn gatling:test
EXPOSE 4200