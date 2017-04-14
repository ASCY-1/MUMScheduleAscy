package com.ascy.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.domain.Profile;
import com.ascy.service.ProfileService;

@RestController
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	
	@RequestMapping("/profile")
	public List<Profile> index(){
		return profileService.getAll();
	}
	
	@RequestMapping("/profile/{id}")
	public Profile view(@PathVariable int id){
		return profileService.getById(id);
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.POST)
	public void create(@RequestBody Profile profile){
		profileService.create(profile);
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.PUT)
	public void update(@RequestBody Profile profile){
		profileService.update(profile);
	}
	@RequestMapping(value="/profile",method=RequestMethod.DELETE)
	public void delete(@RequestBody Profile profile ){
		profileService.delete(profile);
	}
}
