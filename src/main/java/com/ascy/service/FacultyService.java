package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Faculty;
import com.ascy.repository.FacultyRepository;
@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository; 
	
	public List<Faculty> getAll() {
		return (List<Faculty>)facultyRepository.findAll();
	}

	public Faculty getById(int id) {
		return facultyRepository.findOne(id);
	}

	public void create(Faculty faculty) {
		facultyRepository.save(faculty);
		
	}

	public void update(Faculty faculty) {
		facultyRepository.save(faculty);
	}

	public void delete(Faculty faculty) {
		facultyRepository.delete(faculty);
	}
	
	

}
