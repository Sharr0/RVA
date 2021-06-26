drop table if exists fakultet cascade;
drop table if exists departman cascade;
drop table if exists student cascade;
drop table if exists status cascade;

DROP SEQUENCE IF EXISTS fakultet_seq;
DROP SEQUENCE IF EXISTS departman_seq;
DROP SEQUENCE IF EXISTS student_seq;
DROP SEQUENCE IF EXISTS status_seq;

create table fakultet(
	id integer not null,
	naziv varchar(100),
	sediste varchar(50)
);

create table departman(
	id integer not null,
	naziv varchar(100),
	oznaka varchar(10),
	fakultet integer not null
);

create table student(
	id integer not null,
	ime varchar(50),
	prezime varchar(50),
	broj_indeksa varchar(20) not null ,
	status integer not null,
	departman integer not null
);

create table status(
	id integer not null,
	naziv varchar(100),
	oznaka varchar(10)
);

ALTER TABLE fakultet ADD CONSTRAINT pk_fakultet PRIMARY KEY(id);
ALTER TABLE departman ADD CONSTRAINT pk_departman PRIMARY KEY(id);
ALTER TABLE student ADD CONSTRAINT pk_student PRIMARY KEY(id);
ALTER TABLE status ADD CONSTRAINT pk_status PRIMARY KEY(id);

ALTER TABLE departman ADD CONSTRAINT fk_departman_fakultet FOREIGN KEY(fakultet)
	REFERENCES fakultet(id);

ALTER TABLE student ADD CONSTRAINT fk_student_departman FOREIGN KEY(departman)
	REFERENCES departman(id);

ALTER TABLE student ADD CONSTRAINT fk_student_status FOREIGN KEY(status)
	REFERENCES status(id);
	
CREATE INDEX idxpk_fakultet ON fakultet(id);
CREATE INDEX idxpk_departman ON departman(id);
CREATE INDEX idxpk_student ON student(id);
CREATE INDEX idxpk_status ON status(id);

CREATE INDEX idxfk_departman_fakultet ON departman(fakultet);
CREATE INDEX idxfk_student_departman ON student(departman);
CREATE INDEX idxfk_student_status ON student(status);

CREATE SEQUENCE fakultet_seq
INCREMENT 1;
CREATE SEQUENCE departman_seq
INCREMENT 1;
CREATE SEQUENCE student_seq
INCREMENT 1;
CREATE SEQUENCE status_seq
INCREMENT 1;


















	