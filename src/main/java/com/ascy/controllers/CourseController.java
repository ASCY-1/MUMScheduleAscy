package com.ascy.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.domain.Course;

import com.ascy.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/course")
	public List<Course> index(){
		return courseService.getAll();
	}
	
	@RequestMapping("/course/{id}")
	public Course view(@PathVariable int id){
		return courseService.getById(id);
	}
	
	@RequestMapping(value="/course",method=RequestMethod.POST)
	public void create(@RequestBody Course course){
		courseService.create(course);
	}
	
	@RequestMapping(value="/course",method=RequestMethod.PUT)
	public void update(@RequestBody Course course){
		courseService.update(course);
	}
	@RequestMapping(value="/course",method=RequestMethod.DELETE)
	public void delete(@RequestBody Course course ){
		courseService.delete(course);
	}
}