package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.StudentSchedule;
import com.ascy.repository.StudentScheduleRepository;

@Service
public class StudentScheduleService {

	@Autowired
	private StudentScheduleRepository studentScheduleRepository; 
	
	public List<StudentSchedule> getAll() {
		// TODO Auto-generated method stub
		return (List<StudentSchedule>)studentScheduleRepository.findAll();
	}

	public StudentSchedule getById(int id) {
		// TODO Auto-generated method stub
		return studentScheduleRepository.findOne(id);
	}

	public void create(StudentSchedule studentSchedule) {
		studentScheduleRepository.save(studentSchedule);
		
	}

	public void update(StudentSchedule studentSchedule) {
		// TODO Auto-generated method stub
		studentScheduleRepository.save(studentSchedule);
	}

	public void delete(StudentSchedule studentSchedule) {
		// TODO Auto-generated method stub
		studentScheduleRepository.delete(studentSchedule);
	}
	
	

}
