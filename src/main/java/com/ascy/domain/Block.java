package com.ascy.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Block implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Block_Section", joinColumns=@JoinColumn(name="block_id"), inverseJoinColumns=@JoinColumn(name="section_id"))
	private List<Section> sections;
	private String blockname;
	private Date beginDate;
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private Entry entry;
	
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public Block(String blockname, Date beginDate, Date endDate) {
		super();
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
	
	public Entry getEntry() {
		return entry;
	}
	public void setEntry(Entry entry) {
		this.entry = entry;
	}
	
	@Override
	public String toString() {
		return "Block [id=" + id + ", sections=" + sections + ", blockname=" + blockname + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", entry=" + entry + "]";
	}
}
