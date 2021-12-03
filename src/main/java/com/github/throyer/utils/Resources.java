package com.github.throyer.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import com.github.throyer.MigrationsMojo;

import org.apache.log4j.Logger;

public class Resources {
    private Resources() { }

    static final Logger logger = Logger.getLogger(Resources.class);

    public static String getTemplate(String template) {
        try {
            if (MigrationsMojo.DEBUG) {
                logger.debug("try found: " + template);
            }

            var loader = Thread.currentThread().getContextClassLoader();
            var stream = loader.getResourceAsStream(String.format("templates/%s.txt", template));

            if (MigrationsMojo.DEBUG) {
                logger.debug("read template: " + template + " success");
            }

            var text = new BufferedReader(new InputStreamReader(stream))
                    .lines().collect(Collectors.joining("\n"));
            stream.close();
            return text;
        } catch (Exception e) {
            if (MigrationsMojo.DEBUG) {
                logger.debug("read template: " + template + " fail");
            }
            
            return "";
        }
    }
}
