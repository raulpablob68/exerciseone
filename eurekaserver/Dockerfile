FROM openjdk:8-jdk-alpine
ADD target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eurekaserver.jar"]