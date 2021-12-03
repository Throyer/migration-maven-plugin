package com.github.throyer.migrations;

import static com.github.throyer.migrations.NameFormatter.formatNameMigrationJavaBased;
import static com.github.throyer.migrations.TimestampGenerator.timestamp;
import static com.github.throyer.utils.Path.createFile;
import static com.github.throyer.utils.Path.root;
import static java.lang.String.format;
import static java.nio.file.Path.of;

import java.io.FileWriter;
import java.io.IOException;

import com.google.common.io.Resources;

public class JavaMigrationGenerator {

    private JavaMigrationGenerator() { }

    private static final String TEMPLATE_PATH = "V%s__%s.java";
    private static final String SOURCE_PATH = "/src/main/java/db/migration/";

    public static void createJavaMigration(String name) {
        var migrationName = formatNameMigrationJavaBased(name);

        System.out.println("Start generate a file ...\n");

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
                System.out.println("try write data on file ...\n");
                var tempalte = Resources.getResource("templates/java-based.txt");
                var text = tempalte.toString();
                writer.write(format(text, timestamp(), migrationName));
                writer.close();
            } catch (IOException e) { }
        });                        
    }
}
