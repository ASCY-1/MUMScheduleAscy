package com.ascy.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
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
	
	
	
	
	public Student( Profile profile, String regNumber, Entry entry, Track track,
			List<Section> enrolledSections) {
		super();
		
		this.profile = profile;
		this.regNumber = regNumber;
		this.entry = entry;
		this.track = track;
		this.enrolledSections = enrolledSections;
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
