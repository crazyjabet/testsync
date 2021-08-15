FROM ubuntu:20.10

RUN apt-get update -y && apt-get install openjdk-8-jdk -y

ADD ./target/demo-0.0.1-SNAPSHOT.war .

EXPOSE 8080

RUN chmod -R 755 demo-0.0.1-SNAPSHOT.war

ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.war"]