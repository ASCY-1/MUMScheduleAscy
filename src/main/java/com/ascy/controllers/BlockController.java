package com.ascy.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascy.domain.Block;
import com.ascy.service.BlockService;


@RestController
public class BlockController {
	@Autowired
	private BlockService blockService;
	
	
	@RequestMapping(URLConfig.BLOCK)
	public List<Block> index(HttpServletRequest request){
		
		return blockService.getAll();
	}
	
	@RequestMapping(URLConfig.BLOCKDETAIL)
	public Block view(@PathVariable int id){
		return blockService.getById(id);
	}
	
	@RequestMapping(value=URLConfig.BLOCK,method=RequestMethod.POST)
	public void create(@RequestBody Block block){
		blockService.create(block);
	}
	
	@RequestMapping(value=URLConfig.BLOCK,method=RequestMethod.PUT)
	public void update(@RequestBody Block block){
		blockService.update(block);
	}
	@RequestMapping(value=URLConfig.BLOCK,method=RequestMethod.DELETE)
	public void delete(@RequestBody Block block ){
		blockService.delete(block);
	}
}
