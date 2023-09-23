FROM openjdk:11

COPY target/demo_sb_app.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","demo_sb_app.jar"]