package com.cmap.rest.webservices.cmaprestfulwebservices.programcourse;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rmit_program_course")
public class ProgramCourseEntity {

	@EmbeddedId
	private ProgramCourseId programCourseID;

	protected ProgramCourseEntity() {

	}

	public ProgramCourseEntity(ProgramCourseId programCourseID) {
		super();
		this.programCourseID = programCourseID;

	}

	public ProgramCourseId getProgramCourseID() {
		return programCourseID;
	}

	public void setProgramCourseID(ProgramCourseId programCourseID) {
		this.programCourseID = programCourseID;
	}

}
