package com.ascy.controllers;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ascy.IUserSubSystem;
import com.ascy.domain.Profile;
import com.ascy.security.UserAuth;
import com.ascy.security.UserToken;
import com.ascy.service.LoginService;
import com.ascy.service.ProfileService;

@Controller
public class RegistrarController {
	@RequestMapping(URLConfig.ADMIN)
	public String loginPage(){			
		return "admin/admin";
	}
}

