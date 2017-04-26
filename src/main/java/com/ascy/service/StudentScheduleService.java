package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Profile;
import com.ascy.domain.Section;
import com.ascy.domain.Student;
import com.ascy.domain.StudentSchedule;
import com.ascy.repository.StudentRepository;
import com.ascy.repository.StudentScheduleRepository;

@Service
public class StudentScheduleService {

	@Autowired
	private StudentScheduleRepository studentScheduleRepository; 
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<StudentSchedule> getAll() {
		return (List<StudentSchedule>)studentScheduleRepository.findAll();
	}

	public StudentSchedule getById(int id) {
		return studentScheduleRepository.findOne(id);
	}

	public void create(StudentSchedule studentSchedule) {
		studentScheduleRepository.save(studentSchedule);
	}

	public void update(StudentSchedule studentSchedule) {
		studentScheduleRepository.save(studentSchedule);
	}

	public void delete(StudentSchedule studentSchedule) {
		studentScheduleRepository.delete(studentSchedule);
	}

	public void create(Profile p, List<Section> sections) {
		Student s = studentRepository.findByProfile(p);
		s.setEnrolledSections(sections);
		studentRepository.save(s);
	}
	
	

}
