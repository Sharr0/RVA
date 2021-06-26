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
import rva.repository.DepartmanRepository;

@CrossOrigin
@RestController
@Api(tags = {"Departman CRUD operacije"})
public class DepartmanRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//prilikom pokretanja boota, on ce napraviti depRep bin u Beans provided by spring boot:
	@Autowired 
	private DepartmanRepository departmanRepository;
	
	@GetMapping("departman")
	@ApiOperation(value = "Vraća kolekciju svih departmana iz baze podataka")
	public Collection<Departman> getDepartmani() {
		return departmanRepository.findAll();
	}
	
	@GetMapping("departman/{id}")
	@ApiOperation(value = "Vraća departman iz baze podataka čiji je id vrednost prosledjena kao path varijabla")
	public Departman getDepartman(@PathVariable("id") Integer id) {
		return departmanRepository.getOne(id);
	}
	
	@GetMapping("departmanNaziv/{naziv}")
	@ApiOperation(value = "Vraća kolekciju svih departmana iz baze podataka koji u nazivu sadrže string prosleđen kao path varijabla")
	public Collection<Departman>  getDepartmanByNaziv(@PathVariable("naziv") String naziv) {
		return departmanRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("departman")
	@ApiOperation(value = "Upisuje departman u bazu podataka")
	public ResponseEntity<Departman> insertDepartman(@RequestBody Departman departman){
		if(!departmanRepository.existsById(departman.getId())) {
			departmanRepository.save(departman);
			return new ResponseEntity<Departman>(HttpStatus.OK);
		}
		return new ResponseEntity<Departman>(HttpStatus.CONFLICT);
	}
	
	@ApiOperation(value = "Modifikuje postojeći departman u bazi podataka")
	@PutMapping("departman")
	public ResponseEntity<Departman> updateDepartman(@RequestBody Departman departman){
		if(!departmanRepository.existsById(departman.getId())) {
			return new ResponseEntity<Departman>(HttpStatus.NO_CONTENT);
		}
		departmanRepository.save(departman);
		return new ResponseEntity<Departman>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Briše departman iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
	@DeleteMapping("departman/{id}")
	public ResponseEntity<Departman> deleteDepartman(@PathVariable("id") Integer id){
		if(!departmanRepository.existsById(id)) {
			return new ResponseEntity<Departman>(HttpStatus.NO_CONTENT);
		}
		departmanRepository.deleteById(id);
		if(id == -100) {
			jdbcTemplate.execute(
					"INSERT INTO departman(\"id\",\"naziv\", \"oznaka\", \"fakultet\")"
					+ "VALUES (-100, 'Naziv Test','OzT', 1)"
			);
		}
		return new ResponseEntity<Departman>(HttpStatus.OK);
	}
	
}
