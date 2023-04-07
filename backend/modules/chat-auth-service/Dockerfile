FROM openjdk:17.0.2

VOLUME /tmp

EXPOSE 8081

ADD target/auth-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
