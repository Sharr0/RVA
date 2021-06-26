package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.jpa.Departman;
import rva.jpa.Status;
import rva.jpa.Student;
import rva.repository.DepartmanRepository;
import rva.repository.StatusRepository;
import rva.repository.StudentRepository;

@CrossOrigin
@RestController
@Api(tags = {"Departman CRUD operacije"})
public class StudentRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private DepartmanRepository departmanRepository;
	
	@GetMapping("student")
	@ApiOperation(value = "Vraća kolekciju svih studenata iz baze podataka")
	public Collection<Student> getStudenti() {
		return studentRepository.findAll();
	}
	
	@GetMapping("student/{id}")
	@ApiOperation(value = "Vraća studenta iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
	public Student getStudent(@PathVariable("id") Integer id) {
		return studentRepository.getOne(id);
	}
	
	@GetMapping("studentBrojIndeksa/{brojIndeksa}")
	@ApiOperation(value = "Vraća kolekciju svih studenata iz baze podataka koji u broju indeksa sadrže string prosleđen kao path varijabla")
	public Collection<Student> getStudentByBrojIndeksa(@PathVariable("brojIndeksa") String brojIndeksa) {
	 	return studentRepository.findByBrojIndeksaContainingIgnoreCase(brojIndeksa);
	}
	
	@GetMapping("studentStatus/{id}")
	@ApiOperation(value = "Vraća studenta iz baze podataka po id-u statusa čiji je id vrednost prosleđena kao path varijabla")
	public Collection<Student> getStudentByStatus(@PathVariable("id") Integer statusId) {
		Status s = statusRepository.getOne(statusId);
	 	return studentRepository.findByStatus(s);
	}
	
	@GetMapping("studentDepartman/{id}")
	@ApiOperation(value = "Vraća studenta iz baze podataka po id-u departmana čija je vrednost prosleđena kao path varijabla")
	public Collection<Student> getStudentByDepartman(@PathVariable("id") Integer departmanId) {
		Departman d = departmanRepository.getOne(departmanId);
	 	return studentRepository.findByDepartman(d);
	}
	
	@PostMapping("student")
	@ApiOperation(value = "Upisuje studenta u bazu podataka")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
		if(!studentRepository.existsById(student.getId())) {
			studentRepository.save(student);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.CONFLICT);			
	}
	@PutMapping("student")
	@ApiOperation(value = "Modifikuje postojećeg studenta u bazi podataka")	
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		if(!studentRepository.existsById(student.getId())) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		studentRepository.save(student);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("student/{id}")
	@ApiOperation(value = "Briše studenta iz baze podataka ciji je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id) {
		if(!studentRepository.existsById(id)) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		studentRepository.deleteById(id);
		if(id == -100) {
			jdbcTemplate.execute(
					"INSERT INTO student(\"id\",\"ime\", \"prezime\", \"broj_indeksa\", \"status\", \"departman\")"
					+ "VALUES (-100, 'Test Ime','Test Prezime', 'Test Broj_Indeksa',1 , 1)"
			);
		}
		return new ResponseEntity<Student>(HttpStatus.OK);

	} 
	
}
