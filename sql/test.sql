show databases;
create database springbook;

use springbook;

create table users
(
    id       varchar(10),
    name     varchar(10) not null,
    password varchar(10) not null,
    primary key (id)
);

show tables;

insert into users(id, name, password)
VALUES ('1', 'giga', 'password1');

select *
from users;

delete from users;
