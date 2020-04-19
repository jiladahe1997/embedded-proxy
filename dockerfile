FROM openjdk:8u242

WORKDIR /usr/src/app
RUN chmod +x ./mvnw
RUN ./mvnw clean package
COPY ./target/ ./target/

CMD [ "java","-jar","./target/embeddedproxy-0.0.1-SNAPSHOT.jar" ]