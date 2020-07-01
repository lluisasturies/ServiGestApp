FROM java:openjdk-8-jdk-alpine

# add directly the jar
ADD target/*.jar /servigest-backend.jar

# to create a modification date
RUN sh -c 'touch /servigest-backend.jar'

# creates a mount point
VOLUME /tmp

CMD ["java", "-jar", "/servigest-backend.jar", "--spring.profiles.active=prod"]

EXPOSE 8080