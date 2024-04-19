RUN mvn clean package

FROM openjdk:11
ADD target/*.jar ServiGest-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ServiGest-0.0.1-SNAPSHOT.jar"]
