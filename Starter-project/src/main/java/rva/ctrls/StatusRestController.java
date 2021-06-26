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
import rva.jpa.Status;
import rva.repository.StatusRepository;

@RestController
@CrossOrigin
@Api(tags = {"Departman CRUD operacije"})
public class StatusRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping("status")
	@ApiOperation(value = "Vraća kolekciju svih statusa iz baze podataka")
	public Collection<Status> getStatusi(){
		return statusRepository.findAll();
	}
	
	@GetMapping("status/{id}")
	@ApiOperation(value = "Vraca status iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
	public Status getStatus(@PathVariable("id") Integer id) {
		return statusRepository.getOne(id);
	}
	
	@GetMapping("statusNaziv/{naziv}")
	@ApiOperation(value = "Vraća kolekciju svih statusa iz baze podataka koji u nazivu sadrže string prosleđen kao path varijabla")
	public Collection<Status> getStatusByNaziv(@PathVariable("naziv") String naziv) {
		return statusRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("status")
	@ApiOperation(value = "Upisuje status u bazu podataka")
	public ResponseEntity<Status> insertStatus(@RequestBody Status status) {
		if(!statusRepository.existsById(status.getId())) {
			statusRepository.save(status);
			return new ResponseEntity<Status>(HttpStatus.OK);
		}
		return new ResponseEntity<Status>(HttpStatus.CONFLICT);			
	}
	
	@PutMapping("status")
	@ApiOperation(value = "Modifikuje postojeći status u bazi podataka")	
	public ResponseEntity<Status> updateStatus(@RequestBody Status status) {
		if(!statusRepository.existsById(status.getId())) {
			return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
		}
		statusRepository.save(status);
		return new ResponseEntity<Status>(HttpStatus.OK);
	}
	
	@DeleteMapping("status/{id}")
	@ApiOperation(value = "Briše status iz baze podataka ciji je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<Status> deleteStatus(@PathVariable("id") Integer id) {
		if(!statusRepository.existsById(id)) {
			return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
		}
		statusRepository.deleteById(id);
		if(id == -100) {
			jdbcTemplate.execute(
					"INSERT INTO status(\"id\",\"naziv\", \"oznaka\")"
					+ "VALUES (-100, 'Naziv Test','TestB')"
			);
		}
		return new ResponseEntity<Status>(HttpStatus.OK);
	}
}
