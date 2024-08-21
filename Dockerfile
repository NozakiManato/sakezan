FROM eclipse-temurin:21-jdk-alpine
COPY build/libs/sakezan-1.0.0-SNAPSHOT.jar /app/sakezan.jar
CMD [ "java", "-jar", "/app/sakezan.jar" ]
