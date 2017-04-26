package com.ascy.controllers;

public class URLConfig {
	// has GET POST PUT DELETE
	public static final String BLOCK = "/block";
	public static final String BLOCKDETAIL="/block/{id}";
	public static final String COURSE ="/course"; 
	public static final String COURSEDETAIL = "/course/{id}";
	public static final String FACULTY = "/faculty";
	public static final String FACULTYDETAIL = "/faculty/{id}";
	public static final String LOGIN = "/login";
	public static final String PROFILE="/profile";
	public static final String PROFILEDETAIL="/profile/{id}";
	public static final String SECTION="/section";
	public static final String BLOCKSECTION="/block/section/{id}";
	public static final String SECTIONDETAIL="/section/{id}";
	public static final String STUDENT="/student";
	public static final String STUDENTDETAIL="/student/{id}";
	public static final String STUDENTSCHEDULE = "/student/schedule";
	public static final String STUDENTSCHEDULEDETAIL = "/student/schedule/{id}";
	public static final String ME = "/me";
	public static final String FIRST = "/";
	public static final String ADMIN = "/admin";	
	public static final String FACULTY_INDEX = "/facultyIndex";
	public static final String FACULTY_ADD_OFFER="/faculty/addOffer";
	public static final String FACULTY_GET_OFFER = "/faculty/getOffered";
	public static final String FACULTY_DELETE_OFFER = "/faculty/deleteOffer";
	public static final String STUDENT_HOME="/student_home";
	public static final String ENROLL_STUDENT="/enroll";
	public static final String STUDENT_ENROLMENTS="/enrollments";
	public static final int ENTRY_TOTAL = 70;
	public static final double SECTION_MAX = 25.0;
	public static final String COURSE_ADD_PRE_REQ = "/course/{id}";
	
	
}
