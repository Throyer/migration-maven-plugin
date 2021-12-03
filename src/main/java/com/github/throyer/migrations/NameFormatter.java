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

import com.github.throyer.MigrationsMojo;

import org.apache.log4j.Logger;

public class NameFormatter {

    private NameFormatter() {
    }

    static final Logger logger = Logger.getLogger(NameFormatter.class);

    public static String formatNameMigrationJavaBased(String name) {
        if (MigrationsMojo.DEBUG) {
            logger.debug("formatting name: " + name);
        }

        var result = join(EMPTY,
                stream(name
                        .replaceAll(DOT, SPACE)
                        .replaceAll(UNDERSCORE, SPACE)
                        .replaceAll(MINUS, SPACE)
                        .split(SPACE))
                                .map(word -> capitalize(normalize(word, NFD)
                                        .replaceAll(SPECIAL_CHARACTERS, EMPTY)))
                                .toArray(String[]::new));

        if (MigrationsMojo.DEBUG) {
            logger.debug("Formate success. Migration name: " + result);
        }

        return result;
    }

    public static String formatNameMigrationSQLFileBased(String name) {
        if (MigrationsMojo.DEBUG) {
            logger.debug("formatting name: " + name);
        }

        var result = join(UNDERSCORE,
                stream(name
                        .replaceAll(DOT, UNDERSCORE)
                        .replaceAll(MINUS, UNDERSCORE)
                        .split(SPACE))
                                .map(word -> capitalize(normalize(word, NFD)
                                        .replaceAll(SPECIAL_CHARACTERS, EMPTY)))
                                .toArray(String[]::new)).toLowerCase();
        if (MigrationsMojo.DEBUG) {
            logger.debug("Formate success. Migration name: " + result);
        }
        
        return result;
    }
}
