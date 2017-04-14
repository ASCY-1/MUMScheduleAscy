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
		// TODO Auto-generated method stub
		return (List<Faculty>)facultyRepository.findAll();
	}

	public Faculty getById(int id) {
		// TODO Auto-generated method stub
		return facultyRepository.findOne(id);
	}

	public void create(Faculty faculty) {
		facultyRepository.save(faculty);
		
	}

	public void update(Faculty faculty) {
		// TODO Auto-generated method stub
		facultyRepository.save(faculty);
	}

	public void delete(Faculty faculty) {
		// TODO Auto-generated method stub
		facultyRepository.delete(faculty);
	}
	
	

}
