package com.ascy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrarController {
	@RequestMapping(URLConfig.ADMIN)
	public String loginPage(){			
		return "admin/admin";
	}
}

