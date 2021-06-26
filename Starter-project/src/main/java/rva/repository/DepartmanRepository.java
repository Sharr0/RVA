package rva.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.jpa.Departman;

public interface DepartmanRepository extends JpaRepository<Departman, Integer>{
	
	//trazi po nazivu i ignorise dal je malo ili veliko slovo
	Collection<Departman> findByNazivContainingIgnoreCase(String naziv);
	
}
