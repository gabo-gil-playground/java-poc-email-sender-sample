# Example:
# - docker build -t java-poc-email-sender-sample:latest .
# - docker run -p 0.0.0.0:9025:9025 java-poc-email-sender-sample:latest
#
#######################################################################################################################
FROM debian:latest
RUN apt-get update && apt-get install -y --no-install-recommends build-essential libpq-dev ca-certificates
RUN apt-get install -y extra-runtime-dependencies & rm -rf /var/lib/apt/lists/*
RUN update-ca-certificates

#######################################################################################################################
## Official Amazon AWS support for Maven and OpenJDK
FROM maven:3.9.11-amazoncorretto-25 AS build

WORKDIR /src
COPY . .

RUN mvn package spring-boot:repackage

#######################################################################################################################

ENTRYPOINT ["java", "-jar", "/src/target/java-poc-email-sender-sample-1.0.0.jar"]
