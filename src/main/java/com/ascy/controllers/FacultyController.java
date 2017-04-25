package com.ascy.controllers;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.domain.Course;
import com.ascy.domain.Faculty;
import com.ascy.domain.Profile;
import com.ascy.service.FacultyService;
import com.ascy.service.LoginService;

import io.jsonwebtoken.Claims;


@RestController
public class FacultyController {
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(URLConfig.FACULTY)
	public List<Faculty> index(){
		return facultyService.getAll();
	}
	
	@RequestMapping(URLConfig.FACULTYDETAIL)
	public Faculty view(@PathVariable int id){
		return facultyService.getById(id);
	}
	
	@RequestMapping(value=URLConfig.FACULTY,method=RequestMethod.POST)
	public void create(@RequestBody Faculty faculty){
		facultyService.create(faculty);
	}
	
	@RequestMapping(value=URLConfig.FACULTY,method=RequestMethod.PUT)
	public void update(@RequestBody Faculty faculty){
		facultyService.update(faculty);
	}
	
	@RequestMapping(value=URLConfig.FACULTY,method=RequestMethod.DELETE)
	public void delete(@RequestBody Faculty faculty ){
		
		facultyService.delete(faculty);
	}
	
	@RequestMapping(value=URLConfig.FACULTY_ADD_OFFER,method=RequestMethod.POST)
	public void addCourseOffer(@RequestBody List<Course> courses,HttpServletRequest request)throws ServletException{
		Profile p = loginService.currentUserProfile((Claims)request.getAttribute("claims"));		
		facultyService.addCourseOffers(courses,p);		
	}
	
	@RequestMapping(value=URLConfig.FACULTY_GET_OFFER,method=RequestMethod.GET)
	public List<Course> getCourseOffers(HttpServletRequest request)throws ServletException{
		Profile p = loginService.currentUserProfile((Claims) request.getAttribute("claims"));
		return facultyService.getCourseOffers(p);
	}
	
	@RequestMapping(value= URLConfig.FACULTY_DELETE_OFFER,method= RequestMethod.DELETE)
	public void deleteCourseOffer(@RequestBody Course course,HttpServletRequest request) throws ServletException{
		Profile p = loginService.currentUserProfile((Claims) request.getAttribute("claims"));		
		facultyService.deleteCourseOffer(course,p);
	}
	
}
