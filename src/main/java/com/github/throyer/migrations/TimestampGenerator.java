package com.github.throyer.migrations;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.Instant;
import java.time.LocalDateTime;

public class TimestampGenerator {

    private TimestampGenerator() { }

    public static String timestamp() {       
        var date = ofPattern("yyyyMMddhhmm").format(LocalDateTime.now()); 
        Long timestamp = Instant.now().getEpochSecond();
        System.out.println("Create timestamp: " + timestamp + " ...\n");
        return String.format("%s%s", date, timestamp);
    }
}
