FROM openjdk:8
EXPOSE 8081
ADD target/projectmanagerapi.war projectmanagerapi.war
ENTRYPOINT ["java", "-war","/projectmanagerapi.war"]