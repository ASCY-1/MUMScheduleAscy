package com.ascy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(URLConfig.FIRST)
	public String home(){
		return "index";
	}
	
	@RequestMapping(URLConfig.FACULTY2)
	public String loginPage(){			
		return "faculty/faculty";
	}
//	@RequestMapping(URLConfig.PROFILE)
//	public String profilesPage(){			
//		return "profile";
//	}
}

