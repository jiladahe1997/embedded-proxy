FROM openjdk:11.0-jre

WORKDIR /usr/src/app

COPY ./ ./
RUN chmod +x ./mvnw
RUN ./mvnw clean package -Dmaven.test.skip=true
RUN ls -la ./

CMD [ "java","-jar","./target/embeddedproxy-0.0.1-SNAPSHOT.jar" ]