package com.github.throyer.utils;

import static java.nio.file.Paths.get;
import static java.util.Optional.empty;
import static java.util.Optional.of;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Path {
    public static String root() {
        return get("").toAbsolutePath().toString();
    }

    public static Optional<File> createFile(String path) {
        System.out.println("try create file: " + path + " ...\n");

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
