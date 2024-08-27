CREATE SEQUENCE sequence_id START WITH 7 OWNED BY person.id;
ALTER TABLE person ALTER COLUMN "id" SET DEFAULT nextval('sequence_id');
SELECT nextval('sequence_id');

ALTER TABLE person alter column name set not null;
ALTER TABLE person ADD CONSTRAINT UQ_email UNIQUE (email);
ALTER TABLE person ADD CONSTRAINT PK_person_id PRIMARY KEY (id);
	
INSERT INTO person (name, email) VALUES ('Jeka', 'jack@mail.com');
INSERT INTO person (name, email) VALUES ('Vitech', 'vamoss@mail.com');

Select * from person;