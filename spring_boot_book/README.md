# Spring-boot Data Project
## 도서정보 관리 프로젝트

## Spring-Data Project
* spring-data project는 DBMS와 연동하여 CRUD를 구현하는 Project
* spring-JPA(Java Persistance API·Architecture) : ORM(Object Relation Mapping)
* 일반적으로 DBMS와 연동하기 위해서는 SQL 문법, 명령구조 등을 활용
* ORM은 SQL을 사용하지 않고 JAVA 객체(클래스)만을 디자인하여 DBMS와 관련된 CRUD를 구현하는 것을 목표로 탄생된 도구

## Spring-Data-JPA Project
* Spring-Data-JPA Project는 반드시 초기에 DB 설정이 있어야한다
* DB 설정이 없을 경우 Project 시작 자체가 되지 않는다
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

* MySQL 연동 JDBC 설정
```
<dependency>
    <groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<scope>runtime</scope>
</dependency>
```