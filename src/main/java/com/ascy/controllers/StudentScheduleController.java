package com.ascy.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.domain.StudentSchedule;
import com.ascy.service.StudentScheduleService;

@RestController
public class StudentScheduleController {
	@Autowired
	private StudentScheduleService studentScheduleService;
	
	
	@RequestMapping("/studentSchedule")
	public List<StudentSchedule> index(){
		return studentScheduleService.getAll();
	}
	
	@RequestMapping("/studentSchedule/{id}")
	public StudentSchedule view(@PathVariable int id){
		return studentScheduleService.getById(id);
	}
	
	@RequestMapping(value="/studentSchedule",method=RequestMethod.POST)
	public void create(@RequestBody StudentSchedule studentSchedule){
		studentScheduleService.create(studentSchedule);
	}
	
	@RequestMapping(value="/studentSchedule",method=RequestMethod.PUT)
	public void update(@RequestBody StudentSchedule studentSchedule){
		studentScheduleService.update(studentSchedule);
	}
	@RequestMapping(value="/studentSchedule",method=RequestMethod.DELETE)
	public void delete(@RequestBody StudentSchedule studentSchedule ){
		studentScheduleService.delete(studentSchedule);
	}
}
