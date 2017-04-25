package com.ascy.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.domain.Section;
import com.ascy.service.SectionService;

@RestController
public class SectionController {
	@Autowired
	private SectionService sectionService;
	
	
	@RequestMapping(URLConfig.SECTION)
	public List<Section> index(){
		return sectionService.getAll();
	}
	
	@RequestMapping(URLConfig.SECTIONDETAIL)
	public Section view(@PathVariable int id){
		return sectionService.getById(id);
	}
	
	@RequestMapping(value=URLConfig.SECTION,method=RequestMethod.POST)
	public void create(@RequestBody Section section){
		sectionService.create(section);
	}
	
	@RequestMapping(value=URLConfig.SECTION,method=RequestMethod.PUT)
	public void update(@RequestBody Section section){
		System.out.println("=======================================================================");
		System.out.println(section);
		System.out.println("=======================================================================");
		sectionService.update(section);
	}
	@RequestMapping(value=URLConfig.SECTION,method=RequestMethod.DELETE)
	public void delete(@RequestBody Section section ){
		sectionService.delete(section);
	}
}
