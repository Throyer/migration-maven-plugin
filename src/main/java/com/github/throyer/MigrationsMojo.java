package com.github.throyer;

import static com.github.throyer.migrations.JavaMigrationGenerator.createJavaMigration;
import static com.github.throyer.migrations.SQLMigrationGenerator.createSQLFileMigration;
import static org.apache.maven.plugins.annotations.LifecyclePhase.INITIALIZE;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * mvn com.github.throyer:migration-maven-plugin:generate -Dname=Migration-nova
 */
@Mojo(name = "generate", defaultPhase = INITIALIZE)
public class MigrationsMojo extends AbstractMojo {

    @Parameter(property = "type", defaultValue = "java")
    String type;

    @Parameter(property = "name", required = true)
    String name;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (type.equals("sql")) {
            createSQLFileMigration(name);
        } else {
            createJavaMigration(name);
        }
    }
}

