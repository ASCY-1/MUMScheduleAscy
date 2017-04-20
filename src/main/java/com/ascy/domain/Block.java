package com.ascy.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Block {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany
	private List<Section> sections;
	private String blockname;
	private Date beginDate;
	private Date endDate;
	public Block(String blockname, Date beginDate, Date endDate) {
		super();
		this.blockname = blockname;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	public Block(List<Section> sections, String blockname, Date beginDate, Date endDate) {
		super();
		this.sections = sections;
		this.blockname = blockname;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	public Block() {
		super();
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public String getBlockname() {
		return blockname;
	}
	public void setBlockname(String blockname) {
		this.blockname = blockname;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	

}
