package com.ascy.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CascadeType;

@Entity
@NamedQuery(name = "Faculty.findByProfileId", query = "SELECT f FROM Faculty f WHERE f.profile = (?1)")
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="Faculty_Profile", joinColumns=@JoinColumn(name="faculty_id"), inverseJoinColumns=@JoinColumn(name="profile_id"))
	private Profile profile;
	
	//he wants to teach
	@ManyToMany
	private List<Course> proposedCourses;
	// what he is teaching
	@OneToMany(fetch=FetchType.EAGER)
    private List<Section> sectionAssigned;
	 
	public Faculty() {
		super();
	}
	
	public Faculty(Profile profile) {
		super();
		this.profile = profile;
		this.proposedCourses = new ArrayList<Course>();
		this.sectionAssigned = new ArrayList<Section>();
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
