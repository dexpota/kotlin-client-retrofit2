package me.destro.swagger.codegen.kotlin;

import io.swagger.codegen.v3.CodegenType;
import io.swagger.codegen.v3.SupportingFile;
import io.swagger.codegen.v3.generators.kotlin.AbstractKotlinCodegen;

import java.io.File;

@SuppressWarnings("unused")
public class KotlinClientRetrofit2Generator extends AbstractKotlinCodegen {

    // source folder where to write the files
    protected String sourceFolder = "src";
    protected String apiVersion = "1.0.0";


    /**
     * Configures the type of generator.
     *
     * @return the CodegenType for this generator
     * @see io.swagger.codegen.CodegenType
     */
    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    /**
     * Configures a friendly name for the generator.  This will be used by the generator
     * to select the library with the -l flag.
     *
     * @return the friendly name for the generator
     */
    public String getName() {
        return "kotlin-client-retrofit2";
    }

    /**
     * Returns human-friendly help for the generator.  Provide the consumer with help
     * tips, parameters here
     *
     * @return A string value for the help message
     */
    public String getHelp() {
        return "Generates a kotlin client library which uses Retrofit2";
    }

    public KotlinClientRetrofit2Generator() {
        super();

        // set the output folder here
        outputFolder = "generated-code" + File.separator + "kotlin-client-retrofit2";

        /*
          Models.  You can write model files using the modelTemplateFiles map.
          if you want to create one template for file, you can do so here.
          for multiple files for model (generate multiple files for the same model),
          just put another entry in the `modelTemplateFiles` with
          a different extension
         */
        modelTemplateFiles.put(
                "model.mustache", // the template to use
                ".sample");       // the extension for each file to write

        /*
          Api classes.  You can write classes for each Api file with the apiTemplateFiles map.
          as with models, add multiple entries with different extensions for multiple files per
          class
         */
        apiTemplateFiles.put(
                "api.mustache",   // the template to use
                ".sample");       // the extension for each file to write

        /*
          Template Location.  This is the location which templates will be read from.  The generator
          will use the resource stream to attempt to read the templates.
         */
        templateDir = "kotlin-client-retrofit2";

        packageName = "io.swagger.client";

        /*
          Api Package.  Optional, if needed, this can be used in templates
         */
        apiPackage = packageName + ".api";

        /*
          Model Package.  Optional, if needed, this can be used in templates
         */
        modelPackage = packageName + ".model";

        /*
          Additional Properties.  These values can be passed to the templates and
          are available in models, apis, and supporting files
         */
        additionalProperties.put("apiVersion", apiVersion);

        /*
          Supporting Files.  You can write single files for the generator with the
          entire object tree available.  If the input file has a suffix of `.mustache
          it will be processed by the template engine.  Otherwise, it will be copied
         */
        supportingFiles.add(new SupportingFile("myFile.mustache",   // the input template or file
                "",                                                       // the destination folder, relative `outputFolder`
                "myFile.sample")                                          // the output file
        );

    }

    @Override
    public String getDefaultTemplateDir() {
        return templateDir;
    }

}