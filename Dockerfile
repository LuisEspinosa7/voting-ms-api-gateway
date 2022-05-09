FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
COPY target/voting-api-gateway.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar