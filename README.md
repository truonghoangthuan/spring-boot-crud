# spring-boot-crud

Spring Boot CRUD Web application with Pagination and Sorting features using Spring Boot, ThymeLeaf, Spring Data JPA, Hibernate, MySQL database.

## What's inside
This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project and uses these packages:
- Maven
- Spring Core
- Spring Data (Hibernate & MySQL)
- Spring MVC (Tomcat)
- [Thymleaf](https://thymeleaf.org)

![screenshot](https://github.com/truonghoangthuan/spring-boot-crud/blob/master/screenshot.png)

## Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration
Create a MySQL database with the name `springbootdb` and add the credentials to `/resources/application.properties`.  
The default ones are :

```
spring.datasource.url=jdbc:mysql://localhost:3306/spring_boot_crud?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type=TRACE
```

## Usage
Run the project through the IDE and head out to [http://localhost:8080](http://localhost:8080)