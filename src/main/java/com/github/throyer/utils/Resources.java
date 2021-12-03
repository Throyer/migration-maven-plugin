package com.github.throyer.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Resources {
    private Resources() { }

    public static String getTemplate(String template) {
        try {
            var res = Resources.class.getClassLoader().getResource(String.format("templates/%s.txt", template));
            var file = Paths.get(res.toURI()).toFile();
            var br = new BufferedReader(new FileReader(file));
            var text = br.lines().collect(Collectors.joining("\n"));
            br.close();            
            return text;            
        } catch (Exception e) {
            return "";
        }
    }
}
