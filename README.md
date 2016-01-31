README
======

This README describes the spring-data-jpa-postgresql-json project.


What is this?
---------------------------------------------------------
This repo is copied from this: https://github.com/nzhong/spring-data-jpa-h2

* A minimal command line java program, simple!
* Java configuration, no XML
* Spring Data / JPA, and PostgreSQL, with a JSONB column
* StringJsonUserType is taken from this thread: http://stackoverflow.com/questions/15974474/mapping-postgresql-json-column-to-hibernate-value-type
* So it's fairly simple to use a JSONB column in JPA.


How to run?
---------------------------------------------------------
* ```mvn clean package```
* ```java -jar target/app.jar```


Note: if you need to adapt the code to your own path, make sure that you need to change the line in DataProvider.java, <br />
```lef.setPackagesToScan("com.learn.sdjpa.domain");```