package com.github.throyer.migrations;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.Instant;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

public class TimestampGenerator {

    static final Logger logger = Logger.getLogger(TimestampGenerator.class);

    private TimestampGenerator() { }

    public static String timestamp() {       
        var date = ofPattern("yyyyMMddhhmm").format(LocalDateTime.now()); 
        Long timestamp = Instant.now().getEpochSecond();
        logger.debug("Create timestamp: " + timestamp);
        return String.format("%s%s", date, timestamp);
    }
}
