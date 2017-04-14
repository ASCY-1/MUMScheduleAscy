package com.ascy.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.domain.Faculty;
import com.ascy.service.FacultyService;

@RestController
public class FacultyController {
	@Autowired
	private FacultyService facultyService;
	
	
	@RequestMapping("/faculty")
	public List<Faculty> index(){
		return facultyService.getAll();
	}
	
	@RequestMapping("/faculty/{id}")
	public Faculty view(@PathVariable int id){
		return facultyService.getById(id);
	}
	
	@RequestMapping(value="/faculty",method=RequestMethod.POST)
	public void create(@RequestBody Faculty faculty){
		facultyService.create(faculty);
	}
	
	@RequestMapping(value="/faculty",method=RequestMethod.PUT)
	public void update(@RequestBody Faculty faculty){
		facultyService.update(faculty);
	}
	@RequestMapping(value="/faculty",method=RequestMethod.DELETE)
	public void delete(@RequestBody Faculty faculty ){
		facultyService.delete(faculty);
	}
}