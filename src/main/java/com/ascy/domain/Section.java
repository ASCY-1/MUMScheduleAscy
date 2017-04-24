package com.ascy.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ascy.controllers.URLConfig;

@Entity
public class Section implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToOne
	private Faculty faculty;
	
	@ManyToOne
	private Block block;
	
	@ManyToOne
	private Course course;
	private int seatsAvailable;
	final int totalSeats=25;
	
	public Section() {
		super();
	}
	public Section(String name) {
		super();		
		this.seatsAvailable = (int) URLConfig.SECTION_MAX;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	

	@Override
	public String toString() {
		return "Section [id=" + id + ", faculty=" + faculty + ", block=" + block + ", course=" + course
				+ ", seatsAvailable=" + seatsAvailable + ", totalSeats=" + totalSeats + ", name=" + name + "]";
	}
}
