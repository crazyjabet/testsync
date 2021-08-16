FROM 758210838432.dkr.ecr.us-west-2.amazonaws.com/test-app-base
# FROM ubuntu:20.10

# RUN apt-get update -y && apt-get install openjdk-8-jdk -y

ADD ./target/demo-0.0.1-SNAPSHOT.war .
#
RUN chmod -R 755 demo-0.0.1-SNAPSHOT.war

EXPOSE 8080

ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.war"]