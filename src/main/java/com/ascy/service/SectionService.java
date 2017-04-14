package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Section;
import com.ascy.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	private SectionRepository sectionRepository; 
	
	public List<Section> getAll() {
		// TODO Auto-generated method stub
		return (List<Section>)sectionRepository.findAll();
	}

	public Section getById(int id) {
		// TODO Auto-generated method stub
		return sectionRepository.findOne(id);
	}

	public void create(Section section) {
		sectionRepository.save(section);
		
	}

	public void update(Section section) {
		// TODO Auto-generated method stub
		sectionRepository.save(section);
	}

	public void delete(Section section) {
		// TODO Auto-generated method stub
		sectionRepository.delete(section);
	}
	
	

}
