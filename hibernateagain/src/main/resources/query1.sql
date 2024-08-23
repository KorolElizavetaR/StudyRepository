CREATE DATABASE hibernateDB;

CREATE TABLE person
(
	person_id int GENERATED ALWAYS AS IDENTITY (START WITH 1) PRIMARY KEY,	
	person_name varchar(100),
	age int CHECK (age BETWEEN 0 AND 150)
)

SELECT * FROM person;

INSERT INTO person("name", age) VALUES ('Константин', 25);
INSERT INTO person("name", age) 
	VALUES ('Валерия', 19),
			('Василий', 56);