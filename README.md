# hosp-demo


The DB is postgres
The Tables have the following schema:
CREATE TABLE exam(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(20),
    type VARCHAR(20),
	code VARCHAR(20),
	date VARCHAR(20),
	patient VARCHAR(20)
);


CREATE TABLE patient(
    id BIGINT PRIMARY KEY     NOT NULL,
    firstname VARCHAR(20),
    lastname VARCHAR(20),
	gender VARCHAR(20),
	dob VARCHAR(20),
	address VARCHAR(20),
	hospital VARCHAR(20)
);


CREATE TABLE hospital(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(20),
    status VARCHAR(20),
	address VARCHAR(20)
);
