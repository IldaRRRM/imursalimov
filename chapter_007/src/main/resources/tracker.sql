    CREATE DATABASE tracker;

    CREATE TABLE role (
    	id SERIAL PRIMARY KEY,
    	roleName VARCHAR(80)
    	);

    CREATE TABLE rules(
    	id SERIAL PRIMARY KEY, 
    	rules VARCHAR(80)
    	);

    CREATE TABLE role_has_rules(
    	id SERIAL PRIMARY KEY,
    	role_id INT REFERENCES role(id),
    	rules_id INT REFERENCES rules(id) 
   	);

   	CREATE TABLE category(
   		id SERIAL PRIMARY KEY, 
   		categoryName VARCHAR(80)
   		);

   	CREATE TABLE state(
   		id SERIAL PRIMARY KEY,
   		status VARCHAR(80)
   		);

   	CREATE TABLE itemUser(
   		id SERIAL PRIMARY KEY,
   		name VARCHAR(80),
   		role_id INT REFERENCES role(id)
   		);


   	CREATE TABLE item(
   		id SERIAL PRIMARY KEY,
   		itemName VARCHAR(80),
        descr VARCHAR(80),
        created DATE,
   		category_id INT REFERENCES category(id),
   		itemUser_id INT REFERENCES itemUser(id)
   		);

	CREATE TABLE attachs(
		id SERIAL PRIMARY KEY,
		attachName VARCHAR(80),
		item_Id INT REFERENCES item(id)
		);   	

	CREATE TABLE comments(
		id SERIAL PRIMARY KEY,
		body VARCHAR(80),
		item_Id INT REFERENCES item(id)
		);


	INSERT INTO role VALUES ('1', 'admin');
	INSERT INTO role VALUES ('2', 'user');

	INSERT INTO rules VALUES ('1', 'godMode');
	INSERT INTO rules VALUES ('2', 'demigod');

	INSERT INTO role_has_rules VALUES ('1', '1', '1');

	INSERT INTO category VALUES ('1', 'admins');

	INSERT INTO state VALUES ('1', 'ready');

	INSERT INTO itemUser VALUES ('1', 'testUser', '1');

--	INSERT INTO item VALUES ('1', 'first_item', '2019-08-21', '1', '1');

	--INSERT INTO attachs VALUES ('1', 'trololo.png', '1');

	--INSERT INTO comments VALUES ('1', 'first_cooment', '1');






