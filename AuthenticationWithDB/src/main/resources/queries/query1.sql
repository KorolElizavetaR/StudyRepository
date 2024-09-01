CREATE TABLE person
(
	"id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	username varchar (50) NOT NULL,
	"password" varchar NOT NULL,
	birth_date DATE DEFAULT '1970.01.01' NOT NULL CHECK (birth_date BETWEEN '1920.01.01' AND CURRENT_DATE)
);
Select * from person; 

INSERT INTO person (username, "password", birth_date) VALUES ('vanucha100', 'vanucha', '2005.09.12');
INSERT INTO person (username, "password", birth_date) VALUES ('liza', '321456', '2005.01.05');
INSERT INTO person (username, "password", birth_date) VALUES ('qwerty', 'qwerty', '2010.02.07');