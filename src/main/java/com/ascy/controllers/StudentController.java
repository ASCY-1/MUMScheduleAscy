package com.ascy.controllers;


import java.net.URI;
import java.security.SecureRandom;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ascy.domain.Profile;
import com.ascy.domain.Section;
import com.ascy.domain.Student;
import com.ascy.service.LoginService;
import com.ascy.service.StudentService;

import io.jsonwebtoken.Claims;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private LoginService loginService;
	
	@GetMapping(URLConfig.STUDENTSECTIONS)
	public List<Section> registerStudentForSection(HttpServletRequest request) throws ServletException {
			Claims c = (Claims)request.getAttribute("claims");
			Profile  p = loginService.currentUserProfile(c);			
			return studentService.getEnrolledSections(p);
	
	}
	@RequestMapping(URLConfig.STUDENT)
	public List<Student> index(){
		return studentService.getAll();
	}

	@RequestMapping(URLConfig.STUDENTDETAIL)
	public Student view(@PathVariable int id){
		return studentService.getById(id);
	}
	
	@RequestMapping(value=URLConfig.STUDENT,method=RequestMethod.POST)
	public void create(@RequestBody Student student){
		studentService.create(student);
	}
	
	@RequestMapping(value=URLConfig.STUDENT,method=RequestMethod.PUT)
	public void update(@RequestBody Student student){
		studentService.update(student);
	}
	@RequestMapping(value=URLConfig.STUDENT,method=RequestMethod.DELETE)
	public void delete(@RequestBody Student student ){
		studentService.delete(student);
	}
}
