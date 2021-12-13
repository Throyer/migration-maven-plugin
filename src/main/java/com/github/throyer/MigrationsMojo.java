package com.github.throyer;

import static com.github.throyer.migrations.JavaMigrationGenerator.createJavaMigration;
import static com.github.throyer.migrations.SQLMigrationGenerator.createSQLFileMigration;
import static org.apache.log4j.BasicConfigurator.configure;
import static org.apache.maven.plugins.annotations.LifecyclePhase.INITIALIZE;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "generate", defaultPhase = INITIALIZE)
public class MigrationsMojo extends AbstractMojo {

    static {
        configure();
    }

    public static boolean DEBUG;

    @Parameter(property = "verbose", defaultValue = "false")
    boolean verbose;

    @Parameter(property = "sql", defaultValue = "false")
    boolean sql;

    @Parameter(property = "name", required = true)
    String name;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MigrationsMojo.DEBUG = verbose;
        if (sql) {
            createSQLFileMigration(name);
        } else {
            createJavaMigration(name);
        }
    }
}

