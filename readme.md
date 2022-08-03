# Flyway Migrations generator plugin
This plugin is intended to facilitate the creation of java migrations.
Create your migrations with a simple maven command.

Based on typeorm, laravel, entityframework and other frameworks/orms.

> **🚨 disclaimer** *for now the directories where migrations are created is used the spring boot convention with flyway, in the future this will be parameterized* 
>> `src/main/java/db/migration` Java based migrations dir
>> 
>> `src/main/resources/db/migration` sql based migrations dir

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.throyer/migration-maven-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.throyer/migration-maven-plugin)

## Using

make sure you have the `spring boot` dependencies
```xml
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jooq</artifactId>
    </dependency>
```

put it in the list of plugins in pom.xml
```xml
    <plugin>
        <groupId>io.github.throyer</groupId>
        <artifactId>migration-maven-plugin</artifactId>
        <version>2.0.0</version>
    </plugin>
```

generate migation java based file:
```bash
mvn migration:generate -Dname=My-Migration-Name
```

generate migation sql based file:
```bash
mvn migration:generate -Dname=My-Migration-Name -Dsql
```

generate migation with debug:
```bash
mvn migration:generate -Dname=My-Migration-Name -Dverbose
```
