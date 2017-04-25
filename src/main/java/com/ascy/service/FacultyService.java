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

	public List<Course> getCourseOffers(Profile p) throws ServletException{
		Faculty f= facultyRepository.findByProfileId(p);
		if(f!=null){
			return f.getProposedCourses();
		}
		throw new ServletException("Invalid Authorization");
	}

	public void deleteCourseOffer(Course course, Profile p) throws ServletException{
		Faculty f = facultyRepository.findByProfileId(p);
		if(f!=null){
			f.setProposedCourses(f.getProposedCourses().stream().filter(x->x.getId()!=course.getId()).collect(Collectors.toList()));
			facultyRepository.save(f);
			return ;
		}
		throw new ServletException("Invalid Authorization");
	}
	
	

}
