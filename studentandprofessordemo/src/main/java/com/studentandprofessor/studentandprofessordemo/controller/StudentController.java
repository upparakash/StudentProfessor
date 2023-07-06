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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentandprofessor.studentandprofessordemo.exception.StudentException;

import com.studentandprofessor.studentandprofessordemo.model.StudentProfessorAllocation;
import com.studentandprofessor.studentandprofessordemo.model.Students;
import com.studentandprofessor.studentandprofessordemo.repository.StudentRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

	@Autowired
	private StudentRepository srepository;
	@GetMapping("/students")
	public List<Students> getAllStudents() {
		return srepository.findAll();
	}

	

	// create employee rest api
	@PostMapping("/students")
	public Students createStudents(@RequestBody Students students) {
		return srepository.save(students);
	}
	@PostMapping("/studentslist")
	public List<Students> createProfessor(@RequestBody List<Students> students) {
		return srepository.saveAll(students);
	}
	// get employee by id rest api
	@GetMapping("/students/{sid}")
	public ResponseEntity<Students> getStudentsBySid(@PathVariable Long sid) {
		Students students = srepository.findById(sid)
				.orElseThrow(() -> new StudentException("Employee not exist with id :" + sid));
		return ResponseEntity.ok(students);
	}
	
	// update employee rest api
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Students> updateStudents(@PathVariable Long sid, @RequestBody Students studentsDetails){
		Students students = srepository.findById(sid)
				.orElseThrow(() -> new StudentException("Employee not exist with id :" + sid));
		
				
		Students updatedStudents = srepository.save(students);
		return ResponseEntity.ok(updatedStudents);
	}
	
	// delete employee rest api
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudents(@PathVariable Long sid){
		Students students = srepository.findById(sid)
				.orElseThrow(() -> new StudentException("Employee not exist with id :" + sid));
		
		srepository.delete(students);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/StudentProfessorAllocation")
	public List<StudentProfessorAllocation> getStudentProfessorDetails(Long professorid){
		List<StudentProfessorAllocation> lc = srepository.getStudentProfessorDetails(professorid);
		
		return lc;
	}
	
	
}
