package com.cmap.rest.webservices.cmaprestfulwebservices.program;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProgramId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String code;
	private int year;
	
	protected ProgramId(){
		
	}
	public ProgramId(String code, int year) {
		super();
		this.code = code;
		this.year = year;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	
}
