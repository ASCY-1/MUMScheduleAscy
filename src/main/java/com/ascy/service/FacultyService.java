package com.ascy.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Course;
import com.ascy.domain.Faculty;
import com.ascy.domain.Profile;
import com.ascy.repository.FacultyRepository;

import ch.qos.logback.core.net.SyslogOutputStream;


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

	public void addCourseOffers(List<Course> courses,Profile p) throws ServletException{
		Faculty f = facultyRepository.findByProfileId(p);
		List<Course> list;
		if(f!=null){
			list = courses.stream().filter(x->!f.getProposedCourses().contains(x)).collect(Collectors.toList());
			for (Course course : f.getProposedCourses()) {
				list.add(course);
			}
			f.setProposedCourses(list);			
			facultyRepository.save(f);
			
		}
		else{
			throw new ServletException("Invalid Authorization");
		}
	}
	
	

}
