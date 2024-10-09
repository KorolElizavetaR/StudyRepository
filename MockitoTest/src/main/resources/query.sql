CREATE TABLE category
(
	category_name varchar(15) PRIMARY KEY,
	description text
)

INSERT INTO category VALUES
	('FOOD', 'Eatables'),
	('TOYS', 'To play with')

CREATE TABLE product
(
	product_id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	product_name varchar(50) NOT NULL,
	category_name varchar(15) REFERENCES category(category_name) ON DELETE SET NULL,
	unit_price numeric(10, 2) NOT NULL,
	units_in_stock int NOT NULL
)

INSERT INTO product(product_name, category_name, unit_price, units_in_stock) VALUES
	('Cookies', 'FOOD', 2.55, 50),
	('Chocolade', 'FOOD', 3.99, 100),
	('Doll', 'TOYS', 39.86, 23)

CREATE TABLE "order"
(
	order_id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	customer_id int REFERENCES customer(user_id) ON DELETE CASCADE,
	product_id int REFERENCES product(product_id) ON DELETE CASCADE,
	ordered_at timestamp DEFAULT NOW(),
	quantity int check (quantity>0)
)
INSERT INTO "order"(customer_id, product_id, quantity) VALUES
	(2, 3, 1)
	
SELECT * FROM "order"

CREATE TABLE customer
(
	user_id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	username varchar(50) NOT NULL UNIQUE,
	password text NOT NULL,
	role varchar(15) NOT NULL DEFAULT 'ROLE_USER'
)
SELECT * FROM customer
INSERT INTO customer(username, "password", "role") VALUES
	('admin', '$2a$12$P.cRWu9JxEeU50mK4LJW9O/Dr8B.eHmoRs/mpOfTgyGCcrT8mJS82', 'ROLE_ADMIN'),
	('qwerty', '$2a$12$qCdO5zu8wcC3gY3gsEaU6uSfiFbpP6pnCuzRVuKMypDr7LuihqhwK', 'ROLE_USER')
