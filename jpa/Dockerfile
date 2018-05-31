FROM java:8
MAINTAINER liuruichao
ADD ./target/jpa-1.0.jar jpa.jar

ENV LANG C.UTF-8
ENV TZ Asia/Shanghai

EXPOSE 8080
ENTRYPOINT ["/usr/bin/java","-jar","jpa.jar"]
