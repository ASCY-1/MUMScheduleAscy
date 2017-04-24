package com.ascy.controllers;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.IUserSubSystem;
import com.ascy.domain.Profile;
import com.ascy.security.*;
import com.ascy.service.LoginService;
import com.ascy.service.ProfileService;


@RestController
// @Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = URLConfig.LOGIN, method = RequestMethod.POST)
	public UserToken login(@RequestBody UserAuth user) throws ServletException {
		return loginService.authenticate(user);
	}

	@RequestMapping(URLConfig.ME)
	public Profile currentUser() {
		IUserSubSystem profile = profileService;
		return profile.getAll().get(0);
	}

}
