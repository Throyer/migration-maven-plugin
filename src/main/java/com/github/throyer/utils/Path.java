package com.github.throyer.utils;

import static java.nio.file.Paths.get;
import static java.util.Optional.empty;
import static java.util.Optional.of;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import com.github.throyer.MigrationsMojo;

import org.apache.log4j.Logger;

public class Path {

    private Path() { }

    static final Logger logger = Logger.getLogger(Path.class);

    public static String root() {
        return get("").toAbsolutePath().toString();
    }

    public static Optional<File> createFile(String path) {
        if (MigrationsMojo.DEBUG) {
            logger.debug("try create file: " + path);
        }

        var directory = new File(path);
        if (!directory.exists()) {
            try {
                directory.createNewFile();
                return of(directory);
            } catch (IOException exception) {
                exception.printStackTrace();
                return empty();
            }
        }
        return of(directory);
    }
}
