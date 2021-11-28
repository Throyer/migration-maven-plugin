package com.github.throyer.migrations;

import java.time.Instant;

public class TimestampGenerator {
    public static String timestamp() {        
        Long timestamp = Instant.now().getEpochSecond();
        System.out.println("Create timestamp: " + timestamp + " ...\n");
        return timestamp.toString();
    }
}
