package com.github.throyer.migrations;

import static com.github.throyer.migrations.NameFormatter.formatNameMigrationJavaBased;
import static com.github.throyer.migrations.TimestampGenerator.timestamp;
import static com.github.throyer.utils.Path.createFile;
import static com.github.throyer.utils.Path.root;
import static com.github.throyer.utils.Resources.getTemplate;
import static java.lang.String.format;
import static java.nio.file.Path.of;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class JavaMigrationGenerator {

    static final Logger logger = Logger.getLogger(JavaMigrationGenerator.class);

    private JavaMigrationGenerator() { }

    private static final String TEMPLATE_PATH = "V%s__%s.java";
    private static final String SOURCE_PATH = "/src/main/java/db/migration/";

    public static void createJavaMigration(String name) {
        var migrationName = formatNameMigrationJavaBased(name);

        logger.debug("Start generate a file");

        if (!of(root(), SOURCE_PATH).toFile().exists()) {
            of(root(), SOURCE_PATH).toFile().mkdirs();
        }

        var path = of(
            root(),
            SOURCE_PATH,
            format(
                TEMPLATE_PATH,
                timestamp(),
                migrationName
            )
        );

        createFile(path.toString()).ifPresent((file) -> {
            try (FileWriter writer = new FileWriter(file)) {
                logger.debug("try write data on file");
                System.out.println();                
                writer.write(format(getTemplate("java-based"), timestamp(), migrationName));
                writer.close();
                logger.debug("write file success");
            } catch (IOException e) {
                logger.debug("write file fail");
            }
        });                        
    }
}
