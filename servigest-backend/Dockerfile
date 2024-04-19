# Build stage
FROM maven:latest AS build
COPY pom.xml /
COPY src /src
RUN mvn -f /app/pom.xml clean package -DskipTests

# Run stage
FROM openjdk:11
COPY --from=build /target/*.jar /ServiGest-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ServiGest-0.0.1-SNAPSHOT.jar"]
