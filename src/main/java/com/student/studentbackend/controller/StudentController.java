package com.student.studentbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.studentbackend.model.Student;
import com.student.studentbackend.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
	
	private final StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<>(studentService.getStudents(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
		return studentService.updateStudent(student, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
}
