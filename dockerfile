FROM openjdk:8u242

WORKDIR /usr/src/app

COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean package -Dmaven.test.skip=true

CMD [ "java","-jar","./target/embeddedproxy-0.0.1-SNAPSHOT.jar" ]