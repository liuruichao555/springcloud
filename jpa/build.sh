#!/bin/sh
mvn clean

mvn package -DskipTests

docker build -t lrc-jpa ./

# docker run -d -it -p 8080:8080 lrc-jpa bash
