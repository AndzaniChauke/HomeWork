FROM adoptopenjdk:18-jre-hotspot
ADD build/libs/HomeWork-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]