FROM openjdk:8u242

WORKDIR /usr/src/app
COPY ./target/ ./target/

CMD [ "java","-jar","./target/embeddedproxy-0.0.1-SNAPSHOT.jar" ]