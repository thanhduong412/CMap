package com.cmap.rest.webservices.cmaprestfulwebservices.coursetopic;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rmit_course_topic")
public class CourseTopicEntity {

	@EmbeddedId
	public CourseTopicId courseTopicId;
	
	@Column(name = "level")
	public String outcomeLevel;
	
	@Column(name = "requirement")
	public String preReqLevel;
	
	public CourseTopicEntity() {
	};

	public CourseTopicEntity(CourseTopicId courseTopicId, String outcomeLevel, String preReqLevel) {
		super();
		this.courseTopicId = courseTopicId;
		this.outcomeLevel = outcomeLevel;
		this.preReqLevel = preReqLevel;
	}

	public CourseTopicId getCourseTopicId() {
		return courseTopicId;
	}

	public void setCourseTopicId(CourseTopicId courseTopicId) {
		this.courseTopicId = courseTopicId;
	}

	public String getOutcomeLevel() {
		return outcomeLevel;
	}

	public void setOutcomeLevel(String outcomeLevel) {
		this.outcomeLevel = outcomeLevel;
	}

	public String getPreReqLevel() {
		return preReqLevel;
	}

	public void setPreReqLevel(String preReqLevel) {
		this.preReqLevel = preReqLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseTopicId == null) ? 0 : courseTopicId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseTopicEntity other = (CourseTopicEntity) obj;
		if (courseTopicId == null) {
			if (other.courseTopicId != null)
				return false;
		} else if (!courseTopicId.equals(other.courseTopicId))
			return false;
		return true;
	}

}
