package com.ascy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Section {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
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
	
	
	public Section( Faculty faculty, Block block, Course course, int seatsAvailable) {
		super();		
		this.faculty = faculty;
		this.block = block;
		this.course = course;
		this.seatsAvailable = seatsAvailable;
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
}
