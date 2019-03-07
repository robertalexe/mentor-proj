FROM java:8-jdk-alpine

COPY ./target/mentor-project-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch mentor-project-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "mentor-project-0.0.1-SNAPSHOT.jar"]