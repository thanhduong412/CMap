package com.cmap.rest.webservices.cmaprestfulwebservices.program;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "rmit_program")
public class ProgramEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ProgramId programID;
	private String name;
	private String target;

	protected ProgramEntity() {

	}

	public ProgramEntity(ProgramId programID, String name, String target) {
		super();
		this.programID = programID;
		this.name = name;
		this.target = target;
	}

	public ProgramId getProgramID() {
		return programID;
	}

	public void setProgramID(ProgramId programID) {
		this.programID = programID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
