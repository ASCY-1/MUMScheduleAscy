package com.ascy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(URLConfig.FIRST)
	public String home(){
		return "index";
	}
}

