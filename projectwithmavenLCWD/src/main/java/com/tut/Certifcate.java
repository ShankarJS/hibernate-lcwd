package com.tut;

import javax.persistence.Embeddable;

//A separate table won't be created, but the fields of this class will be treated as columns of parent class/table

@Embeddable
public class Certifcate {
	private String course;
	private String duration;
	
	
	
	public Certifcate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	
	public Certifcate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
