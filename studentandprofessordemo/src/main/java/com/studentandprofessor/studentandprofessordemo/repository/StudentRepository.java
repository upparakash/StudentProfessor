package com.studentandprofessor.studentandprofessordemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentandprofessor.studentandprofessordemo.model.StudentProfessorAllocation;
import com.studentandprofessor.studentandprofessordemo.model.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
	@Query(value="select students.sid as sid,students.student_name as studentName,professor.professor_id as professorId,professor.professor_name as professorName from students,professor where students.professor_id=professor.professor_id and professor.professor_id=:pid ",nativeQuery = true)
	
	
	 
	List<StudentProfessorAllocation> getStudentProfessorDetails(@Param("pid") Long pid);

		
	

	

}