package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Student;
import com.ascy.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository; 
	
	
	
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return (List<Student>)studentRepository.findAll();
	}

	public Student getById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findOne(id);
	}

	public void create(Student student) {
		studentRepository.save(student);
		
	}

	public void update(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	public void delete(Student student) {
		// TODO Auto-generated method stub
		studentRepository.delete(student);
	}
	
	

}
