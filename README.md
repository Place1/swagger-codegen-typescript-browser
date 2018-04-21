# Swagger Codegen for the TypescriptBrowser library

# How do I use this code generator?

First, you'll need to clone this repository and build it using Java 1.7

```
git clone https://github.com/Place1/swagger-codegen-typescript-browser.git
cd swagger-codegen-typescript-browser
mvn package
```

You'll also need to download the latest swagger codegen jar file. Currently i've only tested
this code generator with swagger codegen 2.3.1.

```
wget http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.3.1/swagger-codegen-cli-2.3.1.jar -O "swagger-codegen-cli.jar"
```

Once the code generator has been built and you've downloaded the swagger-codegen-cli.jar
you should be ready to use this code generator.

You can use it by invoking the swagger codegen jar with this code generator jar
added to the java classpath.

Here's how you do it:

```
java -cp /path/to/swagger-codegen-cli.jar:./target/TypescriptBrowser-swagger-codegen-1.0.0.jar \
  io.swagger.codegen.Codegen \
  -l TypescriptBrowser \
  -i /path/to/swagger.yaml \
  -o ./test
```
