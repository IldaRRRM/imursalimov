CREATE DATABASE cars;

CREATE TABLE body_car(
	 id SERIAL PRIMARY KEY,
	 name VARCHAR(80)
);

CREATE TABLE engine(
	 id SERIAL PRIMARY KEY,
	 name VARCHAR(80)
);

CREATE TABLE transmission(
	 id SERIAL PRIMARY KEY,
	 name VARCHAR(80)
);

CREATE TABLE car(
	id SERIAL PRIMARY KEY, 
	name VARCHAR(80),
	manufactur_year DATE,
	body_id INTEGER REFERENCES body_car(id),
	engine_id INTEGER REFERENCES engine(id),
	transmission_id INTEGER REFERENCES transmission(id)
);

INSERT INTO body_car VALUES (1, 'Universal');
INSERT INTO body_car VALUES (2, 'Sedan');
INSERT INTO body_car VALUES (4, 'SUV');
INSERT INTO body_car VALUES (5, 'MINIVAN');

INSERT INTO engine VALUES (1, 'External combustion engine');
INSERT INTO engine VALUES (2, 'Internal combustion engine');
INSERT INTO engine VALUES (3, 'Electric');

INSERT INTO transmission VALUES (1, 'Auto');
INSERT INTO transmission VALUES (2, 'Mechanical');

INSERT INTO car VALUES (1, 'Zhigul', '1970-01-01', 1, 2, 2);
INSERT INTO car VALUES (2, 'Tesla', '2019-01-01', 2, 3, 1);

SELECT c.id, c.name, c.manufactur_year, b.name AS body, e.name AS engine, t.name AS transmission FROM car AS c 
INNER JOIN body_car AS b ON c.body_id = b.id
 INNER JOIN engine AS e ON c.engine_id = e.id
  INNER JOIN transmission AS t ON c.transmission_id = t.id;


SELECT b.id, b.name AS body_name, c.name AS not_used_in FROM body_car AS b INNER JOIN car AS c ON b.id <> c.body_id;

SELECT e.id, e.name AS engine_type, c.name AS not_used_in FROM engine AS e INNER JOIN car AS c ON e.id <> c.engine_id;

SELECT t.id, t.name AS transmission, c.name AS not_used_in FROM transmission AS t INNER JOIN car AS c ON t.id <> c.transmission_id;
 



