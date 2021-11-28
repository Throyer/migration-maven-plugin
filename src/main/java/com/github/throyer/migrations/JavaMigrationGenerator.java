package com.github.throyer.migrations;

import static com.github.throyer.migrations.NameFormator.formatNameMigrationJavaBased;
import static com.github.throyer.migrations.TimestampGenerator.timestamp;
import static com.github.throyer.utils.Path.createFile;
import static com.github.throyer.utils.Path.root;
import static java.lang.String.format;
import static java.nio.file.Path.of;

import java.io.FileWriter;
import java.io.IOException;

public class JavaMigrationGenerator {

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
                writer.write(format("""
                package db.migration;
                
                import static org.jooq.impl.DSL.*;
                import static org.jooq.impl.SQLDataType.*;
                import org.flywaydb.core.api.migration.BaseJavaMigration;
                import org.flywaydb.core.api.migration.Context;

                /**
                 * @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
                 */
                public class V%s__%s extends BaseJavaMigration {
                    public void migrate(Context context) throws Exception {
                        var create = using(context.getConnection());
                        // create.transaction(configuration -> {
                        //     using(configuration)
                        //         .createTableIfNotExists(\"foo\")
                        //             .column(\"id\", BIGINT.identity(true))
                        //             .column(\"bar\", VARCHAR(100).nullable(false))
                        //         .constraints(
                        //             primaryKey(\"id\"))
                        //         .execute();
                        // });
                    }
                }
                """, timestamp(), migrationName));
                writer.close();
            } catch (IOException e) { }
        });                        
    }
}
