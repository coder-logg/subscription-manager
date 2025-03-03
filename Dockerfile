FROM openjdk:17
COPY target/subscription-manager-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]