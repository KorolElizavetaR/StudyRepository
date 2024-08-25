CREATE TABLE person
(
	person_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	full_name varchar UNIQUE NOT NULL
);
SELECT * FROM person;
DROP TABLE person;

CREATE TABLE passport
(
	person_id int PRIMARY KEY REFERENCES person(person_id) ON DELETE CASCADE,
	passport_id int GENERATED ALWAYS AS IDENTITY (START WITH 10000 INCREMENT BY 1)
);
SELECT * FROM passport;
DROP TABLE passport;

INSERT INTO person (full_name) 
	VALUES ('Виконт Алеся Степановна'),
			('Игнатовец Артем Александрович'),
			('Фролова Татьяна Александровна'),
			('Бисмут Ксения Евгеньевна'),
			('Ишакович Иван Васильевич');

INSERT INTO passport (person_id) VALUES (1), (2), (3), (4), (5);
	
	