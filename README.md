# Swagger Codegen for the TypescriptBrowser library

## How do I use this code generator?

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

## But why?
This code generator is a fork of the Typescript-Fetch generator that
ships with swagger codegen.

This code generator attempts to improve upon the output of the original
Typescript-Fetch generator in the following ways:

* Zero dependencies
  - The Typescript-Fetch generator has made use of external dependencies such as
    'querystring', 'portable-fetch' and 'url' which have caused headaches for many
    users. These external dependencies have caused issues such as declaration file
    conflicts/duplications, build tool related bugs and code bloat.
* Supports features that are unfortuantly broken in multiple versions of the
  Typescript-Fetch codegenerator
  - multipart/form-data requests are supported via `FormData`
  - `HTTP 204 No Content` responses are now correctly handled. API responses
    documented in your swagger spec that don't have a schema will also be
    handled correctly. The Typescript-Fetch generator attempts to call `response.json()`
    on these types of APIs which results in a json parsing exception (can't parse no content).
* Adds support for pre/post request middleware functions.
  - This is a very useful feature that many HTTP libraries include by default.
  - The Typescript-Fetch generator allows for a custom fetch implementation to be
    passed, a feature that can be used to implement pre/post request middleware,
    but middleware is a powerful feature that consuming projects could benefit
    from greatly.
* Emits a single file `api.ts`
  - This just keeps it simple. No accidental importing from `./lib` `./lib/api.ts` `./lib/dist/api.js` etc.
    By avoiding an `index.ts` or `package.json` file, or `dist/` folder, there's only 1 place
    where the code lives and only 1 place where the code can be imported from, keeping
    your project just a little bit cleaner.
* Operations uses a single options object to hold the request parameters for the operation (path, query, body).
  - The Typescript-Fetch generator used to do this in swagger 2.2.3 but has moved to positional
    arguments for more recent versions
  - Using a single argument has some advantages, namely, api methods have a very consistent signature
    with only a single input argument at most. Parameter names are clear to read when they are
    passed to object keys rather than as positional arguments.
* Only outputs class based APIs
  - This is a subjective point as there is value in different programming styles
    such as the functional programming interfaces provided by Typescript-Fetch.
  - Supporting multiple programming styles is a burden and a potential source of bugs.
  - Leaving the functional programming interface out of this library allows it to
    be slimmed down.
  - A future "Typescript-Functional" code generator could be written that focuses
    on the best possible functional programming interface.
