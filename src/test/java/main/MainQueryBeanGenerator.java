package main;

import org.avaje.ebean.typequery.generator.Generator;
import org.avaje.ebean.typequery.generator.GeneratorConfig;

import java.io.IOException;

public class MainQueryBeanGenerator {

  public static void main(String[] args) throws IOException {

    GeneratorConfig config = new GeneratorConfig();
    //config.setClassesDirectory("./target/classes");
    //config.setDestDirectory("./src/main/java");
    //config.setDestResourceDirectory("./src/main/resources");

    config.setEntityBeanPackage("org.example.domain");
    //config.setDestPackage("org.example.domain.query");

    config.setOverwriteExistingFinders(true);

    Generator generator = new Generator(config);

    generator.generateQueryBeans();

    // Additionally generate 'finder's
    generator.generateFinders();
    generator.modifyEntityBeansAddFinderField();
  }
}
