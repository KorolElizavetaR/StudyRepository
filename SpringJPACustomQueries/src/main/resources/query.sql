CREATE TABLE person
(
	personID int GENERATED ALWAYS AS IDENTITY (START WITH 10000 INCREMENT BY 1) PRIMARY KEY,
	full_name varchar UNIQUE NOT NULL,
	birth_date DATE DEFAULT '1970.01.01' NOT NULL CHECK (birth_date BETWEEN '1920.01.01' AND CURRENT_DATE)
);
SELECT * FROM person;
DROP TABLE person;

CREATE TABLE product
(
	product_id int GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) NOT NULL,
	customer int,
	product_name varchar NOT NULL,
	CONSTRAINT FK_customer FOREIGN KEY (customer) REFERENCES person(personID) ON DELETE SET NULL
);
SELECT * FROM product ORDER BY customer;
DROP TABLE product;

INSERT INTO person (full_name, age) 
	VALUES ('Виконт Алеся Степановна', '1999.03.07')
			('Игнатовец Артем Александрович', '2003.12.23'),
			('Фролова Татьяна Александровна','2010.08.01'),
			('Бисмут Ксения Евгеньевна', '2004.05.14'),
			('Ишакович Иван Васильевич', '1991.01.17');

INSERT INTO product (customer, product_name) VALUES
	(10001, 'Книга'),
	(10003, 'Брелок'),
	(10003, 'Мышка'),
	(10001, 'Ручка'),
	(10000, 'Тетрадь');

INSERT INTO product (product_name) VALUES ('Машинка'), ('Кубики'), ('Cапоги'), ('Мишура'), ('Гирлянда');
	
	