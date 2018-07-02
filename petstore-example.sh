#!/bin/bash
set -e

mvn clean package

CUSTOM_GEN_JAR=./target/TypescriptBrowser-swagger-codegen-*-shaded.jar

java -jar ${CUSTOM_GEN_JAR} generate \
  -l TypescriptBrowser \
  -i http://petstore.swagger.io/v2/swagger.json \
  -o example
