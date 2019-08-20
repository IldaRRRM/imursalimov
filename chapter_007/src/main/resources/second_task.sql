    CREATE DATABASE second_task;

	CREATE TABLE type(id SERIAL PRIMARY KEY,
 	name VARCHAR(80));

	CREATE TABLE product(
 	id SERIAL PRIMARY KEY,
 	name VARCHAR(80),
 	type_id INTEGER REFERENCES type(id),
 	expired_date DATE,
 	price REAL);


    INSERT INTO type VALUES (1, 'СЫР');
 	INSERT INTO type VALUES (2, 'МОЛОКО');
 	INSERT INTO type VALUES (3, 'МОРОЖЕНОЕ');

 	INSERT INTO product VALUES (1, 'Дорблю', 1, '2019-09-17', 35);
 	INSERT INTO product VALUES (2, 'Домик в дервене', 2, '2019-10-2', 35.2);
	INSERT INTO product VALUES (3, 'БРИ', 1, '2019-09-05', 250);

	INSERT INTO product values (4, 'PARMALAT', 2, '2019-08-20', 90);
	INSERT INTO product values (5, 'ЧИСТАЯ ЛИНИЯ', 3, '2019-09-01', 50);

    SELECT * FROM product AS a INNER JOIN type as b ON a.type_id = b.id where b.name = 'СЫР';
	SELECT * FROM product where name ~ 'МОРОЖЕНОЕ';
	SELECT * FROM product where EXTRACT(MONTH from expired_date) = 9;
	SELECT * FROM product where price = (SELECT max(price) from product);
    SELECT b.name, COUNT(a.type_id) FROM product AS a INNER JOIN type AS b ON a.type_id = b.id where b.name = 'СЫР' group by a.type_id, b.name; 
    SELECT a.id, a.name, a.expired_date, a.price, b.name as type_name FROM product AS a INNER JOIN type as b ON a.type_id = b.id where b.name in ('СЫР', 'МОЛОКО');  
    SELECT b.name, COUNT(a.type_id) FROM product AS a INNER JOIN type as b ON a.type_id = b.id group by a.type_id, b.name HAVING COUNT(a.type_id) < 10;
    SELECT a.id, a.name, a.expired_date, a.price, b.name as type_name FROM product AS a INNER JOIN type as b ON a.type_id = b.id;
    







