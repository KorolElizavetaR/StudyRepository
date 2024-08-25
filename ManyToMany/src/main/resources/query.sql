CREATE TABLE actor
(
	actor_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	full_name varchar UNIQUE NOT NULL
);
SELECT * FROM actor;
DROP TABLE actor;

CREATE TABLE movie
(
	movie_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	movie_name varchar NOT NULL
);
SELECT * FROM movie;
DROP TABLE movie;

CREATE TABLE actor_movie(
	actor_id int REFERENCES actor(actor_id),
	movie_id int REFERENCES movie(movie_id),
	PRIMARY KEY(actor_id, movie_id)
);
SELECT * FROM actor_movie
	JOIN actor USING (actor_id)
	JOIN movie USING (movie_id);
DROP TABLE actor_movie;

INSERT INTO actor (full_name) 
	VALUES ('Киану Ривз'), ('Маркус Чонг'), ('Кристиан Бэйл');

INSERT INTO movie (movie_name) 
	VALUES ('Матрица'), ('Пантера'), ('Американский психопат'), ('Машинист');

INSERT INTO actor_movie	VALUES (1, 1), (3, 3), (3,4), (2, 1), (2,2);

	