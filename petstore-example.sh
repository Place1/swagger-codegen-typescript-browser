#!/bin/bash
set -e

SWAGGER_JAR=./swagger-codegen-cli-2.3.1.jar
CUSTOM_GEN_JAR=./target/TypescriptBrowser-swagger-codegen-1.0.0.jar

if [[ ! -f "$SWAGGER_JAR" ]]; then
  wget http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.3.1/swagger-codegen-cli-2.3.1.jar -O $SWAGGER_JAR
fi

mvn clean
mvn package

java -cp ${SWAGGER_JAR}:${CUSTOM_GEN_JAR} io.swagger.codegen.SwaggerCodegen \
  generate \
  -l TypescriptBrowser \
  -i http://petstore.swagger.io/v2/swagger.json \
  -o example
