package com.ascy.controllers;

import javax.servlet.ServletException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ascy.IUserSubSystem;
import com.ascy.domain.Profile;
import com.ascy.security.*;
import com.ascy.service.LoginService;
import com.ascy.service.ProfileService;

import java.util.*;
//@RestController
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	private ProfileService profileService; 
	
	@RequestMapping(value= URLConfig.LOGIN, method=RequestMethod.POST)
	public UserToken login(@RequestBody UserAuth user) throws ServletException{			
			return loginService.authenticate(user);			
	}
	
	@RequestMapping(URLConfig.ME)
	public List<Profile> currentUser(){			
			IUserSubSystem profile = profileService;
			return profile.getAll();
	}
//	@RequestMapping(URLConfig.HOME)
//	public String loginPage(){			
//		return "login/login";
//	}
}


