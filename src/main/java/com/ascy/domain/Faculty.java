package com.ascy.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
	private Profile profile;
	
	//he wants to teach
	@ManyToMany
	private List<Course> proposedCourses;
	// what he is teaching
	@OneToMany
    private List<Section> sectionAssigned;
	 
	public Faculty() {
		super();
	}
	public Faculty(Profile profile, List<Course> proposedCourses, List<Section> sectionAssigned) {
		super();
		this.profile = profile;
		this.proposedCourses = proposedCourses;
		this.sectionAssigned = sectionAssigned;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public List<Course> getProposedCourses() {
		return proposedCourses;
	}
	public void setProposedCourses(List<Course> proposedCourses) {
		this.proposedCourses = proposedCourses;
	}
	public List<Section> getSectionAssigned() {
		return sectionAssigned;
	}
	public void setSectionAssigned(List<Section> sectionAssigned) {
		this.sectionAssigned = sectionAssigned;
	}
	
	
	
}
