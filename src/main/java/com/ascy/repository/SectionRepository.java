package com.ascy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ascy.domain.Block;
import com.ascy.domain.Section;

public interface SectionRepository extends CrudRepository<Section, Integer> {
	
	List<Section> findByBlock(Block block);

}
