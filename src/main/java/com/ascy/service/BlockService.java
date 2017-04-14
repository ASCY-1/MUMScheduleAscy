package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Block;
import com.ascy.repository.BlockRepository;

@Service
public class BlockService {
	
	@Autowired
	private BlockRepository blockRepository; 
	
	public List<Block> getAll() {
		// TODO Auto-generated method stub
		return (List<Block>)blockRepository.findAll();
	}

	public Block getById(int id) {
		// TODO Auto-generated method stub
		return blockRepository.findOne(id);
	}

	public void create(Block block) {
		blockRepository.save(block);
		
	}

	public void update(Block block) {
		// TODO Auto-generated method stub
		blockRepository.save(block);
	}

	public void delete(Block block) {
		// TODO Auto-generated method stub
		blockRepository.delete(block);
	}
	
	

	

}
