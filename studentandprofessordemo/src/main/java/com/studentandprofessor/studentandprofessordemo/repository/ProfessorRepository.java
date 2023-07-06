package com.studentandprofessor.studentandprofessordemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.studentandprofessor.studentandprofessordemo.model.Professor;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	

	

}