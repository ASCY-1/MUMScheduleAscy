package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.IUserSubSystem;
import com.ascy.domain.Faculty;
import com.ascy.domain.Profile;
import com.ascy.domain.Student;
import com.ascy.repository.FacultyRepository;
import com.ascy.repository.ProfileRepository;
import com.ascy.repository.StudentRepository;
@Service
public class ProfileService implements IUserSubSystem{

	@Autowired
	private ProfileRepository profileRepository; 
	@Autowired
	private FacultyRepository facultyRepository; 
	@Autowired
	private StudentRepository studentRepository; 
	
	public List<Profile> getAll() {
		return (List<Profile>)profileRepository.findAll();
	}

	public Profile getById(int id) {
		return profileRepository.findOne(id);
	}

	public void create(Profile profile) {
		switch(profile.getRole()){
			case FACULTY :
				Faculty faculty = new Faculty(profile);
				facultyRepository.save(faculty);
				break;
			case STUDENT : 
				Student student = new Student(profile);
				studentRepository.save(student);
				break;
			case ADMIN :
			default:
				profileRepository.save(profile);
			
		}
		
	}

	public void update(Profile profile) {
		profileRepository.save(profile);
	}

	public void delete(Profile profile) {
		profileRepository.delete(profile);
	}
}
