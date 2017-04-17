package com.ascy.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.security.UserAuth;

@RestController
public class LoginController {
	
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public boolean login(@RequestBody UserAuth user){
		return false;
	}
}
