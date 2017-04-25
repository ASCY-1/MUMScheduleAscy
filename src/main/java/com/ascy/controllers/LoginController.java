package com.ascy.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.domain.Profile;
import com.ascy.security.*;
import com.ascy.service.LoginService;

import io.jsonwebtoken.Claims;

@RestController
// @Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = URLConfig.LOGIN, method = RequestMethod.POST)
	public UserToken login(@RequestBody UserAuth user) throws ServletException {
		return loginService.authenticate(user);
	}

	@RequestMapping(URLConfig.ME)
	public Profile currentUser(HttpServletRequest request) {
		Claims c =(Claims) request.getAttribute("claims");
		return loginService.currentUserProfile(c);
	}

}
