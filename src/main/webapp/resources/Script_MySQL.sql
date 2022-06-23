
 create database if not exists db1 CHARACTER SET utf8 COLLATE utf8_general_ci;
 use db1;
 CREATE TABLE infouser (
  id int NOT NULL AUTO_INCREMENT,
 name varchar(15),
 surname varchar(25),
 age int,
 address varchar(255),
 img varchar(255),
 message text,
 birthday date,
 PRIMARY KEY (id)
  ) ;
  
INSERT INTO infouser (name, surname, age, address, img, message, birthday)
VALUES
('Don', 'Thurtlesov', 30, 'Брест, ул. Брест', 'img url...', 'Сообщение по юзеру)', '15 05 1995');

select * from infouser;