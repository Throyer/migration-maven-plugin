package com.github.throyer.migrations;

import static com.github.throyer.migrations.NameFormator.formatNameMigrationSQLFileBased;
import static com.github.throyer.migrations.TimestampGenerator.timestamp;
import static com.github.throyer.utils.Path.createFile;
import static com.github.throyer.utils.Path.root;
import static java.lang.String.format;
import static java.nio.file.Path.of;

import java.io.FileWriter;
import java.io.IOException;

public class SQLMigrationGenerator {

    private static final String TEMPLATE_PATH = "V%s__%s.sql";
    private static final String SOURCE_PATH = "/src/main/resources/db/migration/";

    public static void createSQLFileMigration(String name) {
        var migrationName = formatNameMigrationSQLFileBased(name);

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
                writer.write(format("""
                -- my sql migration
                """, timestamp(), migrationName));
                writer.close();
            } catch (IOException e) { }
        });                        
    }
}
