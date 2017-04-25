package com.ascy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrarController {
	@RequestMapping(URLConfig.ADMIN)
	public String adminHomePage(){			
		return "admin/admin";
	}
	@RequestMapping(URLConfig.FACULTY_INDEX)
	public String facultyHomePage(){
		return "faculty/faculty";
	}
@RequestMapping(URLConfig.STUDENT_INDEX)
	public String studentHomePage(){
		return "student/student";
	}
	
}

