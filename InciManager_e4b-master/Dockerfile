FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk wget maven
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
WORKDIR /manager
ADD . /manager
EXPOSE 80
RUN cd /manager
CMD mvn spring-boot:run