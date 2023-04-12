FROM openjdk:17.0.2

VOLUME /tmp

EXPOSE 8080

ADD target/messaging-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
