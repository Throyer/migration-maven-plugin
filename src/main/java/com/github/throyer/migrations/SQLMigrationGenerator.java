package com.github.throyer.migrations;

import static com.github.throyer.migrations.NameFormatter.formatNameMigrationSQLFileBased;
import static com.github.throyer.migrations.TimestampGenerator.timestamp;
import static com.github.throyer.utils.Path.createFile;
import static com.github.throyer.utils.Path.root;
import static java.lang.String.format;
import static java.nio.file.Path.of;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

import com.github.throyer.MigrationsMojo;

public class SQLMigrationGenerator {

    static final Logger logger = Logger.getLogger(SQLMigrationGenerator.class);

    private static final String TEMPLATE_PATH = "V%s__%s.sql";
    private static final String SOURCE_PATH = "/src/main/resources/db/migration/";

    private SQLMigrationGenerator() { }

    public static void createSQLFileMigration(String name) {
        var migrationName = formatNameMigrationSQLFileBased(name);

        if (MigrationsMojo.DEBUG) {
            logger.debug("Start generate a file");
        }

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
                if (MigrationsMojo.DEBUG) {
                    logger.debug("try write data on file");
                }

                writer.write("");
                writer.close();

                if (MigrationsMojo.DEBUG) {
                    logger.debug("write file success");
                }
            } catch (IOException e) {
                if (MigrationsMojo.DEBUG) {
                    logger.debug("write file fail");
                }
            }
        });                        
    }
}
