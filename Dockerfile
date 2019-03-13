FROM openjdk:11-jdk
RUN mkdir -p /usr/local/GoogleSearcher
WORKDIR /usr/local/GoogleSearcher

ARG JAR_FILE=foo
ADD target/${JAR_FILE} /usr/local/GoogleSearcher/service.jar

EXPOSE 8080
ADD src/main/docker/run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
