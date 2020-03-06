package com.cmap.rest.webservices.cmaprestfulwebservices.course;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="rmit_courses")
public class CourseEntity {
	@Id
	@Column(name = "course_code")
	private String courseCode;
	@Column(name = "title")
	private String title;
	@Column(name = "credits")
	private int credits;
	
	
	protected CourseEntity(){
		
	}
	
	public CourseEntity(String courseCode, String title, int credits) {
		super();
		this.courseCode = courseCode;
		this.title = title;
		this.credits = credits;
	}

	public String getcourseCode() {
		return courseCode;
	}
	
	public void setcourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "RmitCourse [courseCode=" + courseCode + ", title=" + title + ", credits=" + credits + "]";
	}
	
	
	
	
}
