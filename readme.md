# Flyway Migrations generator plugin
This plugin is intended to facilitate the creation of java migrations.
Create your migrations with a simple maven command.

Based on typeorm, laravel, entityframework and other frameworks/orms.

> **🚨 disclaimer** *for now the directories where migrations are created is used the spring boot convention with flyway, in the future this will be parameterized* 
>> `src/main/java/db/migration` Java based migrations dir
>> 
>> `src/main/resources/db/migration` sql based migrations dir

## Using

put the repository in your pom.xml
```xml
    <repositories>
        <repository>
            <id>migration-maven-plugin</id>
            <url>file://${project.basedir}/lib/migration-maven-plugin-1.0.0.jar</url>
        </repository>
    </repositories>
    ...

    <plugin>
        <groupId>com.github.throyer</groupId>
        <artifactId>migration-maven-plugin</artifactId>
        <version>1.0.0</version>
    </plugin>
```

generate migation java based file:
```bash
mvn migration:generate -Dname=My-Migration-Name
```

generate migation sql based file:
```bash
mvn migration:generate -Dname=My-Migration-Name -Dtype=sql
```
