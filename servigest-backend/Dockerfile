# Build stage
FROM maven:latest AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package

# Run stage
FROM openjdk:11
COPY --from=build /app/target/app*.jar /app/ServiGest-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ServiGest-0.0.1-SNAPSHOT.jar"]
