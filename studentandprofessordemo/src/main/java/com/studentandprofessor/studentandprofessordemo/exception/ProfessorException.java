package com.studentandprofessor.studentandprofessordemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProfessorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ProfessorException(String message) {
		super(message);
	}
}
