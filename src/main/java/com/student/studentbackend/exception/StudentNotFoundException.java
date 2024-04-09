package com.student.studentbackend.exception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String message) {
		super(message);
	}
}
