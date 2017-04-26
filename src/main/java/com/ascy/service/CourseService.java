package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Course;
import com.ascy.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository; 
	
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return (List<Course>)courseRepository.findAll();
	}

	public Course getById(int id) {
		// TODO Auto-generated method stub
		return courseRepository.findOne(id);
	}

	public void create(Course course) {
		courseRepository.save(course);
		
	}

	public void update(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
	}

	public void delete(Course course) {
		// TODO Auto-generated method stub
		courseRepository.delete(course);
	}

	public void addPreReq(Course preReq, int courseId) {
		Course c = courseRepository.findOne(courseId);
		c.setPreReq(preReq);
		courseRepository.save(c);
		
	}
}
