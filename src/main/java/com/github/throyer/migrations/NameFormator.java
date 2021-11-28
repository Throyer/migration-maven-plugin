package com.github.throyer.migrations;

import static com.github.throyer.Constraints.DOT;
import static com.github.throyer.Constraints.EMPTY;
import static com.github.throyer.Constraints.MINUS;
import static com.github.throyer.Constraints.SPACE;
import static com.github.throyer.Constraints.SPECIAL_CHARACTERS;
import static com.github.throyer.Constraints.UNDERSCORE;
import static java.lang.String.join;
import static java.text.Normalizer.normalize;
import static java.text.Normalizer.Form.NFD;
import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.capitalize;

public class NameFormator {
    public static String formatNameMigrationJavaBased(String name) {
        System.out.println("formating name: " + name + " ...\n");
        
        var result = join(EMPTY, 
            stream(name
                .replaceAll(DOT, SPACE)
                .replaceAll(UNDERSCORE, SPACE)
                .replaceAll(MINUS, SPACE)
            .split(SPACE))
                .map(word -> capitalize(normalize(word, NFD)
                    .replaceAll(SPECIAL_CHARACTERS, EMPTY)))
                        .toArray(String[]::new));

        System.out.println("Formate success. Migration name: " + result + " ...\n");
        return result;
    }
}
