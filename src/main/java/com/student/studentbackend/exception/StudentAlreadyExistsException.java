package com.student.studentbackend.exception;

public class StudentAlreadyExistsException extends RuntimeException {
	public StudentAlreadyExistsException(String message) {
		super(message);
	}
}
