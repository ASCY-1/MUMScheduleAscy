package com.ascy.controllers;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ascy.domain.Profile;
import com.ascy.domain.Section;
import com.ascy.domain.Student;
import com.ascy.service.LoginService;
import com.ascy.service.StudentScheduleService;
import com.ascy.service.StudentService;

import io.jsonwebtoken.Claims;

@RestController
public class StudentController {
	
	@Autowired
	private StudentScheduleService studentScheduleService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	private StudentService studentService;
	
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
	
	@RequestMapping(value=URLConfig.ENROLL_STUDENT, method=RequestMethod.POST)
	public void create(@RequestBody List<Section> sections, HttpServletRequest request){
		Profile p = loginService.currentUserProfile((Claims) request.getAttribute("claims"));
		studentScheduleService.create(p,sections);
	}
	
	@RequestMapping(URLConfig.STUDENT_ENROLMENTS)
	public Student studentEnrollments(HttpServletRequest request){
		Profile p = loginService.currentUserProfile((Claims) request.getAttribute("claims"));
		return studentService.getByProfile(p);
	}
}
