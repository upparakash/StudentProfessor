package com.studentandprofessor.studentandprofessordemo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.studentandprofessor.studentandprofessordemo.exception.ProfessorException;
import com.studentandprofessor.studentandprofessordemo.model.Professor;

import com.studentandprofessor.studentandprofessordemo.repository.ProfessorRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class ProfessorController {

	@Autowired
	private ProfessorRepository prepository;
	@GetMapping("/professor")
	public List<Professor> getAllProfessor() {
		return prepository.findAll();
	}
	

	

	// create employee rest api
	@PostMapping("/professor")
	public Professor createProfessor(@RequestBody Professor professor) {
		return prepository.save(professor);
	}
	@PostMapping("/professorlist")
	public List<Professor> createProfessor(@RequestBody List<Professor> professor) {
		return prepository.saveAll(professor);
	}
	
	// get employee by id rest api
	@GetMapping("/professor/{professorId}")
	public ResponseEntity<Professor> getProfessorByProfessorId(@PathVariable Long professorId) {
		Professor professor = prepository.findById(professorId)
				.orElseThrow(() -> new ProfessorException("Employee not exist with id :" + professorId));
		return ResponseEntity.ok(professor);
	}
	
	// update employee rest api
	
	@PutMapping("/professor/{professorId}")
	public ResponseEntity<Professor> updateProfessor(@PathVariable Long professorId, @RequestBody Professor professorDetails){
		Professor professor = prepository.findById(professorId)
				.orElseThrow(() -> new ProfessorException("Employee not exist with id :" + professorId));
		
	
		Professor updatedProfessor = prepository.save(professor);
		return ResponseEntity.ok(updatedProfessor);
	}
	
	// delete employee rest api
	@DeleteMapping("/professor/{professorId}")
	public ResponseEntity<Map<String, Boolean>> deleteProfessor(@PathVariable Long professorId){
		Professor professor = prepository.findById(professorId)
				.orElseThrow(() -> new ProfessorException("Employee not exist with id :" + professorId));
		
		prepository.delete(professor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	


	
	
}
