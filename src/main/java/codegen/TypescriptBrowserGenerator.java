package codegen;

import io.swagger.codegen.*;
import io.swagger.codegen.languages.AbstractTypeScriptClientCodegen;

public class TypescriptBrowserGenerator extends AbstractTypeScriptClientCodegen {

  @Override
  public String getName() {
    return "TypescriptBrowser";
  }

  public String getHelp() {
    return "Generates a TypescriptBrowser client library.";
  }

  public TypescriptBrowserGenerator() {
    super();

    // clear import mapping (from default generator) as TS does not use it
    // at the moment
    importMapping.clear();

    // set the output folder here
    outputFolder = "generated-code/TypescriptBrowser";

    /**
     * Template Location.  This is the location which templates will be read from.  The generator
     * will use the resource stream to attempt to read the templates.
     */
    embeddedTemplateDir = templateDir = "TypescriptBrowser";

    /**
     * Supporting Files.  You can write single files for the generator with the
     * entire object tree available.  If the input file has a suffix of `.mustache
     * it will be processed by the template engine.  Otherwise, it will be copied
     */
    supportingFiles.add(new SupportingFile("api.mustache", "", "api.ts"));

    /**
     * Additional model properties that will be made available to the
     * template rendering context.
     */
    additionalProperties.put("modelPropertyNaming", getModelPropertyNaming());

    reservedWords.add("requestParameters");
    reservedWords.add("headerParameters");
    reservedWords.add("queryParameters");
    reservedWords.add("formData");
  }
}
