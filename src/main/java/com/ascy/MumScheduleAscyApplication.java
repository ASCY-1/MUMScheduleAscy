package com.ascy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ascy.controllers.URLConfig;
import com.ascy.filters.AdminFilter;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class MumScheduleAscyApplication {
	@Bean
	 public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new AdminFilter());
        registrationBean.addUrlPatterns(URLConfig.BLOCK);
        registrationBean.addUrlPatterns(URLConfig.BLOCKDETAIL);
        registrationBean.addUrlPatterns(URLConfig.COURSE);
        registrationBean.addUrlPatterns(URLConfig.COURSEDETAIL);
        registrationBean.addUrlPatterns(URLConfig.FACULTY);
        registrationBean.addUrlPatterns(URLConfig.FACULTYDETAIL);
        registrationBean.addUrlPatterns(URLConfig.PROFILE);
        registrationBean.addUrlPatterns(URLConfig.PROFILEDETAIL);
        registrationBean.addUrlPatterns(URLConfig.SECTION);
        registrationBean.addUrlPatterns(URLConfig.SECTIONDETAIL);
        registrationBean.addUrlPatterns(URLConfig.STUDENT);
        registrationBean.addUrlPatterns(URLConfig.STUDENTDETAIL);
        registrationBean.addUrlPatterns(URLConfig.STUDENTSCHEDULE);
        registrationBean.addUrlPatterns(URLConfig.STUDENTSCHEDULEDETAIL);
        registrationBean.addUrlPatterns(URLConfig.ME);
        registrationBean.addUrlPatterns(URLConfig.FACULTY_ADD_OFFER);
        registrationBean.addUrlPatterns(URLConfig.FACULTY_GET_OFFER);
        registrationBean.addUrlPatterns(URLConfig.FACULTY_DELETE_OFFER);
        registrationBean.addUrlPatterns(URLConfig.ENROLL_STUDENT);
        registrationBean.addUrlPatterns(URLConfig.STUDENT_ENROLMENTS);
        return registrationBean;
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(MumScheduleAscyApplication.class, args);
	}

}
