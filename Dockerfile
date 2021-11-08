FROM adoptopenjdk/openjdk11:alpine-jre  
ARG JAR_FILE=earring-details-core/target/earring-details-core-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app  
COPY ${JAR_FILE} dama-api.jar
ENTRYPOINT ["jheroku container:push webava","-jar","dama-api.jar"]
EXPOSE 8080