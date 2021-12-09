package com.github.throyer.migrations;

import java.sql.Timestamp;

import com.github.throyer.MigrationsMojo;

import org.apache.log4j.Logger;

public class TimestampGenerator {

    static final Logger logger = Logger.getLogger(TimestampGenerator.class);

    private TimestampGenerator() { }

    public static String timestamp() {       
        Long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        
        if (MigrationsMojo.DEBUG) {
            logger.debug("Create timestamp: " + timestamp);
        }

        return timestamp.toString();
    }
}
