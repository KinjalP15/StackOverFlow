FROM openjdk
COPY "./build/libs/StackOverflow-0.0.1-SNAPSHOT.jar" app/StackOverFlow/
WORKDIR app/StackOverFlow/
EXPOSE 8085
ENTRYPOINT ["java", "-jar","StackOverflow-0.0.1-SNAPSHOT.jar"]