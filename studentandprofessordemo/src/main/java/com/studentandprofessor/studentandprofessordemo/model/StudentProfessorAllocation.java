package com.studentandprofessor.studentandprofessordemo.model;
/*select students.sid,
 * students.student_name as studentName,
 * professor.professor_id as professorId,
 * professor.professor_name as professorName from students,
 * professor where students.professor_id=professor.professor_id and professor_id=:pid
 */

public interface StudentProfessorAllocation {
	public Long getSid() ;
	public String getStudentName() ;	
	public Long getProfessorId() ;
	public String getProfessorName() ;

}
