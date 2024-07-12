Функциональность

Загрузка данных с сайта и их сохранение в базу данных при первом запуске

Просмотр списка пассажиров с возможностью сортировки и фильтрации

Поиск пассажиров по имени

Пагинация списка пассажиров

Отображение статистики по пассажирам

Кэширование данных для повышения производительности

Технологии
Java 21
Spring Boot 3
Spring JPA
PostgreSQL 12
Liquibase
RESTful API
HTML5/CSS, Bootstrap

## Сборка и запуск

1. Клонируйте репозиторий:
```sh
git clone hhttps://github.com/haisenberggoodman/Titanic-statistics-board
cd Titanic-statistics-board

Настройка БД PostgreSQL:
create database titanic;
create user titanicuser with encrypted password 'password';
grant all privileges on database titanic to titanicuser;


Измените настройки базы данных в application.yml:
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/titanic
    username: titanicuser
    password: password

Соберите и запустите приложение:

mvn clean install
mvn spring-boot:run
