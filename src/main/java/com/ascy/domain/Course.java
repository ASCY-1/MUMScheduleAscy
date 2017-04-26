package com.ascy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String courseCode;
	private String courseTitle;
	@OneToOne
	private Course preReq;
	
	public Course() {
		super();
	}
	public Course(String courseCode, String courseTitle) {
		super();
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
	}
	public Course(String courseCode, String courseTitle, Course preReq) {
		super();
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.preReq = preReq;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public Course getPreReq() {
		return preReq;
	}
	public void setPreReq(Course preReq) {
		this.preReq = preReq;
	}

}
