package com.student.studentbackend.service;

import java.util.List;

import com.student.studentbackend.model.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	List<Student> getStudents();
	Student updateStudent(Student student, Long id);
	Student getStudentById(Long id);
	void deleteStudent(Long id);

}
