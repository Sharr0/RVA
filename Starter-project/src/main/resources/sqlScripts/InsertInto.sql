--Fakultet podaci

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Fakultet tehnickih nauka', 'Novi Sad');

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Pravni fakultet', 'Kosovska Mitrovica');

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Ekonomski fakultet', 'Subotica');

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Medicinski fakultet', 'Beograd');

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Medicinski fakultet', 'Novi Sad');

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Saobracajni fakultet', 'Beograd');

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Filozofski fakultet', 'Novi Sad');

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Prirodno-matematicki fakultet', 'Kosovska Mitrovica');

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Poljoprivredni fakultet', 'Zubin Potok');

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (NEXTVAL('fakultet_seq'), 'Gradjevinski fakultet', 'Subotica');

--TEST--

INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES (-100, 'TestNaz', 'TestSed');

--TEST--

--Departman podaci

INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES (NEXTVAL('departman_seq'), 'Departman za racunarstvo i automatiku', 'RA', 1);

INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES (NEXTVAL('departman_seq'), 'Departman za industrijsko inzenjerstvo i menadzment', 'IIM', 1);

INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES (NEXTVAL('departman_seq'), 'Departman za arhitekturu i urbanizam', 'AIU', 1);

INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES (NEXTVAL('departman_seq'), 'Departman za tehnicku mehaniku', 'TM', 1);

INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES (NEXTVAL('departman_seq'), 'Departman za saobracaj', 'SOO', 6);

--TEST--

INSERT INTO "departman"("id", "naziv", "oznaka", "fakultet")
VALUES (-100, 'TestNaz', 'TestOz', 1);

--TEST--

--Status podaci

INSERT INTO "status"("id", "naziv", "oznaka")
VALUES (NEXTVAL('status_seq'), 'Budzet', 'B');

INSERT INTO "status"("id", "naziv", "oznaka")
VALUES (NEXTVAL('status_seq'), 'Samofinansiranje', 'S');

INSERT INTO "status"("id", "naziv", "oznaka")
VALUES (NEXTVAL('status_seq'), 'Gostujuci student', 'G');

INSERT INTO "status"("id", "naziv", "oznaka")
VALUES (NEXTVAL('status_seq'), 'Student sa posebnim potrebama', 'PP');

INSERT INTO "status"("id", "naziv", "oznaka")
VALUES (NEXTVAL('status_seq'), 'Student na daljinu', 'D');

--TEST--

INSERT INTO "status"("id", "naziv", "oznaka")
VALUES (-100, 'TestNaz', 'TestOz');

--TEST--

--Student podaci

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
VALUES (NEXTVAL('student_seq'), 'Petar', 'Petrovic', 'IT15/2015', 1, 2 );

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
VALUES (NEXTVAL('student_seq'), 'Marko', 'Markovic', 'IT80/2018', 2, 2);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
VALUES (NEXTVAL('student_seq'), 'Sofija', 'Rajkovski', 'SO20/2018', 1, 5);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
VALUES (NEXTVAL('student_seq'), 'Tijana', 'Tomic', 'RA1/2020', 1, 1);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
VALUES (NEXTVAL('student_seq'), 'Jovana', 'Jokic', 'IT5/2013',1, 2);

--TEST--

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
VALUES (-100, 'TestIme', 'TestPrz', 'TestBrI',1, 1);

--TEST--

