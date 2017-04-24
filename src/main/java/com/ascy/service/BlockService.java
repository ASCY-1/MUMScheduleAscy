package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ascy.IBlockSubSystem;
import com.ascy.domain.Block;
import com.ascy.repository.BlockRepository;

@Service
public class BlockService implements IBlockSubSystem{
	
	@Autowired
	private BlockRepository blockRepository; 
	
	public List<Block> getAll() {
		return (List<Block>)blockRepository.findAll();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public Block getById(int id) {
		return blockRepository.findOne(id);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Block create(Block block) {
		blockRepository.save(block);
		return block;
	}

	public void update(Block block) {
		blockRepository.save(block);
	}

	public void delete(Block block) {
		blockRepository.delete(block);
	}
	
	

	

}
