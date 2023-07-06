package com.studentandprofessor.studentandprofessordemo.model;



import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.OneToMany;

import jakarta.persistence.*;


@Entity
@Table(name = "professor")
public class Professor {
	
	public Professor(long professorId, String professorName, String subject) {
		super();
		this.professorId = professorId;
		this.professorName = professorName;
		this.subject = subject;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long professorId;
	
	@Column(name = "professorName")
	private String professorName;

	@Column(name = "subject")
	private String subject;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "sub")
	List<Students> students;
	
	public Professor() {
		
	}

	public long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", professorName=" + professorName + ", subject="
				+ subject + ", getProfessorName()=" + getProfessorName()
				+ ", getSubject()=" + getSubject() + ", getProfessorId()=" + getProfessorId()   + "]";
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	
	
}