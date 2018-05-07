#!/bin/bash

docker run \
  --rm \
  -it \
  -v maven-cache:/root/.m2 \
  -v `pwd`:/code \
  -w /code \
  maven:3-jdk-7-alpine \
    mvn clean package
