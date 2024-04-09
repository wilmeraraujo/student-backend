package com.student.studentbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.studentbackend.exception.StudentAlreadyExistsException;
import com.student.studentbackend.exception.StudentNotFoundException;
import com.student.studentbackend.model.Student;
import com.student.studentbackend.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentAlreadyExists(student.getEmail())) {
			throw new StudentAlreadyExistsException(student.getEmail()+" already exists!");
		}
		return studentRepository.save(student);
	}

	private boolean studentAlreadyExists(String email) {
		// TODO Auto-generated method stub
		return studentRepository.findByEmail(email).isPresent();
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).map(st ->{
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setDepartment(student.getDepartment());
			return studentRepository.save(st);
		}).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could  not be found"));
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Sorry, student not found"));
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		if(!studentRepository.existsById(id)) {
			throw new StudentNotFoundException("Sorry, student not found delete");
		}
		studentRepository.deleteById(id);
		
	}

}
