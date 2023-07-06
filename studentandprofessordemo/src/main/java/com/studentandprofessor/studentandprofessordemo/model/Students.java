package com.studentandprofessor.studentandprofessordemo.model;




import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class Students {
	
	public Students(long sid, String studentName, Professor sub) {
		super();
		this.sid = sid;
		this.studentName = studentName;
		this.sub = sub;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sid;
	
	@Column(name = "studentName")
	private String studentName;

	
	
	
	
	@JsonBackReference
	
	@JoinColumn(name = "professorId")
	
	@ManyToOne
	private Professor sub;
	
	public Students() {
		
	}


		public long getSid() {
		return sid;
	}


	public void setSid(long sid) {
		this.sid = sid;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Professor getSub() {
		return sub;
	}


	public void setSub(Professor sub) {
		this.sub = sub;
	}


		@Override
	public String toString() {
		return "Students [sid=" + sid + ", studentName=" + studentName + ", sub=" + sub
				+   "]";
	}

	
	
	}