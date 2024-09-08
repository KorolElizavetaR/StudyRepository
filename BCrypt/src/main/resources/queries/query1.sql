CREATE TABLE person
(
	"id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	username varchar (50) NOT NULL,
	"password" varchar NOT NULL
);
Select * from person; 

