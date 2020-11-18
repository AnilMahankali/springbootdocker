FROM java:8
EXPOSE 8080
ADD /target/springboottemplate-0.0.1-SNAPSHOT.jar springboottemplate.jar
ENTRYPOINT ["java","-jar","springboottemplate.jar"]