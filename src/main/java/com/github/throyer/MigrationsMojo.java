package com.github.throyer;

import static org.apache.maven.plugins.annotations.LifecyclePhase.INITIALIZE;

import java.sql.Timestamp;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "generate", defaultPhase = INITIALIZE)
public class MigrationsMojo extends AbstractMojo {

    @Parameter(property = "type", defaultValue = "java")
    String type;

    @Parameter(property = "name", required = true)
    String name;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        var timestamp = new Timestamp(System.currentTimeMillis()).getTime();

        var filename = String.format("%s__%s.java", timestamp, name.replaceAll("-", "_"));

        System.out.println(filename);
    }

}

