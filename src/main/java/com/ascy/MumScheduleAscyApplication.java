package com.ascy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MumScheduleAscyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MumScheduleAscyApplication.class, args);
	}
	
//	@RestController 
	@Controller
	public class HomeContoller {
	    @RequestMapping("/")
	    public String index() {
	        return "home";
	    }
	    @RequestMapping("/home")
	    public String home() {
	        return "home";
	    }
	}
}
