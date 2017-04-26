package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Profile;
import com.ascy.domain.Student;
import com.ascy.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository; 
	
	
	
	public List<Student> getAll() {
		return (List<Student>)studentRepository.findAll();
	}

	public Student getById(int id) {
		return studentRepository.findOne(id);
	}

	public void create(Student student) {
		studentRepository.save(student);
	}

	public void update(Student student) {
		studentRepository.save(student);
	}

	public void delete(Student student) {
		studentRepository.delete(student);
	}
	
	public Student getByProfile(Profile p) {
		return studentRepository.findByProfile(p);
	}

}
