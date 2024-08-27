CREATE TABLE person
(
	id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name varchar (30) NOT NULL UNIQUE,
	email varchar UNIQUE
);
SELECT * FROM person;

		
INSERT INTO person (name, email) VALUES 
	('Jeka', 'jack@mail.com'),
	('Sheon', 'IamAmoron@gmail.com'),
	('Tom', 'ThomasFrank@gmail.com'),
	('Vitech', 'vamoss@mail.com'),
	('Vishnya', 'Vishkorol25@gmail.com'),
	('Irma', 'IrmaLair@gmail.com'),
	('Ron', 'RonWhite@gmail.com');
