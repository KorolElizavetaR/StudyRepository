CREATE DATABASE hibernateDB;

CREATE TABLE person
(
	person_id int GENERATED ALWAYS AS IDENTITY (START WITH 1) PRIMARY KEY,	
	person_name varchar(100),
	age int CHECK (age BETWEEN 0 AND 150)
)

SELECT * FROM person;

INSERT INTO person(person_name, age) 
	VALUES ('Валерия', 15),
			('Женя', 13);