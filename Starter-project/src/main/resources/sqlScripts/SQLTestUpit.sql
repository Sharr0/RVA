--1. izlistati sve fakultete
select * from fakultet;

--2. izlistati fakultete sa sedistem u novom sadu
select * from fakultet
where sediste like 'Novi Sad';

--3. izlistati
select sum(status)
from student
where status=1;

select * from student

--4. svi nazivi koji pocinju sa slovom p
select naziv
from fakultet
where naziv like 'P%';

--5. izlistati departmane sa fakultetima
select d.*, f.naziv from departman d, fakultet f
where d.fakultet = f.id;

--6. izlistati sve studente na budzetu
select s.*, st.naziv
from student s, status st
where s.status = st.id
	and st.naziv like 'Budzet';
	
--7. izlistati sve studente na ftnu
select s.*, f.naziv
from student s, fakultet f, departman d
where s.departman = d.id
	and d.fakultet = f.id
		and f.naziv like 'Fakultet tehnickih nauka';

--8. izlistati sve studente na ftnu koji su na budzetu
select s.*, f.naziv, st.naziv
from student s, fakultet f, departman d, status st
where s.departman = d.id
	and d.fakultet = f.id
	and f.naziv like 'Fakultet tehnickih nauka'
	and s.status = st.id
	and st.naziv like 'Budzet';