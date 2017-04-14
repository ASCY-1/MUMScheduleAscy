package com.ascy.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.domain.Student;
import com.ascy.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/student")
	public List<Student> index(){
		return studentService.getAll();
	}
	
	@RequestMapping("/student/{id}")
	public Student view(@PathVariable int id){
		return studentService.getById(id);
	}
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public void create(@RequestBody Student student){
		studentService.create(student);
	}
	
	@RequestMapping(value="/student",method=RequestMethod.PUT)
	public void update(@RequestBody Student student){
		studentService.update(student);
	}
	@RequestMapping(value="/student",method=RequestMethod.DELETE)
	public void delete(@RequestBody Student student ){
		studentService.delete(student);
	}
}
