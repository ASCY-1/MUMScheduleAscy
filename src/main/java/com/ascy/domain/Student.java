package com.ascy.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@NamedQuery(name = "Student.findByProfile", query = "SELECT s FROM Student s WHERE s.profile = (?1)")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="Student_Profile", joinColumns=@JoinColumn(name="student_id"), inverseJoinColumns=@JoinColumn(name="profile_id"))
	private Profile profile;
	private String regNumber;
	
	@Enumerated(EnumType.STRING)
	private Entry entry;
	
	@Enumerated(EnumType.STRING)
	private Track track; 
	
	@OneToMany
	private List<Section> enrolledSections;
	
	public Student(){
		super();
	}
	
	
	
	
	public Student( Profile profile) {
		super();
		this.profile = profile;
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
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public Entry getEntry() {
		return entry;
	}
	public void setEntry(Entry entry) {
		this.entry = entry;
	}
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
	}
	public List<Section> getEnrolledSections() {
		return enrolledSections;
	}
	public void setEnrolledSections(List<Section> enrolledSections) {
		this.enrolledSections = enrolledSections;
	}

}
