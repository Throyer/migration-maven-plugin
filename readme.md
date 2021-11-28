# Flyway Migrations generator plugin
This plugin is intended to facilitate the creation of java migrations.
Create your migrations with a simple maven command.

Based on typeorm, laravel, entityframework and other frameworks/orms.

## Using

```bash
mvn migration:generate -Dname=My-Migration-Name
```


sql files:
```bash
mvn migration:generate -Dname=My-Migration-Name -Dtype=sql
```