FROM maven:latest
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11
ADD target/*.jar ServiGest-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ServiGest-0.0.1-SNAPSHOT.jar"]
