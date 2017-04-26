package com.ascy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.List;
@Entity
public class StudentSchedule {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@OneToMany
	private List<Section> section;
	
	@ManyToMany
	private List <Student> students;

	private String status;
	
	public StudentSchedule() {
		super();
	}

	public StudentSchedule(List<Section> section, List<Student> students) {
		super();
		this.section = section;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Section> getSection() {
		return section;
	}

	public void setSection(List<Section> section) {
		this.section = section;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
