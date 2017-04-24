package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Block;
import com.ascy.domain.Section;
import com.ascy.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	private SectionRepository sectionRepository; 
	
	public List<Section> getAll() {
		return (List<Section>)sectionRepository.findAll();
	}

	public Section getById(int id) {
		return sectionRepository.findOne(id);
	}

	public void create(Section section) {
		sectionRepository.save(section);
		
	}

	public void update(Section section) {
		sectionRepository.save(section);
	}

	public void delete(Section section) {
		sectionRepository.delete(section);
	}
	
	public List<Section> findByBlock(Block block) {
		return (List<Section>)sectionRepository.findByBlock(block);
	}
	

}
