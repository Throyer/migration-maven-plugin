# Flyway Migrations generator plugin
This plugin is intended to facilitate the creation of java migrations.
Create your migrations with a simple maven command.

Based on typeorm, laravel, entityframework and other frameworks/orms.

> **🚨 disclaimer** *for now the directories where migrations are created is used the spring boot convention with flyway, in the future this will be parameterized* 
>> `src/main/java/db/migration` Java based migrations dir
>> 
>> `src/main/resources/db/migration` sql based migrations dir

## jitpack.oi
[![Release](https://jitpack.io/v/throyer/migration-maven-plugin.svg)](https://jitpack.io/#throyer/migration-maven-plugin)

## Using

put the jitpack.io repository on pom.xml
```xml
<pluginRepositories>
    <pluginRepository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </pluginRepository>
</pluginRepositories>
```

make sure you have the `spring boot` dependencies
```xml
<dependencies>
    ...
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jooq</artifactId>
    </dependency>
    ...
</dependencies>
```

put it in the list of plugins in pom.xml
```xml
<build>
    ...
    <plugins>
        ...
        <plugin>
            <groupId>com.github.throyer</groupId>
            <artifactId>migration-maven-plugin</artifactId>
            <version>1.2.7</version>
        </plugin>
        ...
    </plugins>
    ...
</build>
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
