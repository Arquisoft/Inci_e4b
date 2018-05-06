FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk wget maven
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
WORKDIR /dashboard
ADD . /dashboard
EXPOSE 80
RUN cd /dashboard
CMD mvn spring-boot:run