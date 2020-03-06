package com.cmap.rest.webservices.cmaprestfulwebservices.coursetopic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name="rmit_course_topic")
public class CourseTopicId implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="course_code")
	public String courseCode;
	
	@Column(name="topic_code")
	public String topicCode;

	public CourseTopicId() {}
	
	public CourseTopicId(String courseCode, String topicCode) {
		super();
		this.courseCode = courseCode;
		this.topicCode = topicCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getTopicCode() {
		return topicCode;
	}

	public void setTopicCode(String topicCode) {
		this.topicCode = topicCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
		result = prime * result + ((topicCode == null) ? 0 : topicCode.hashCode());
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
		CourseTopicId other = (CourseTopicId) obj;
		if (courseCode == null) {
			if (other.courseCode != null)
				return false;
		} else if (!courseCode.equals(other.courseCode))
			return false;
		if (topicCode == null) {
			if (other.topicCode != null)
				return false;
		} else if (!topicCode.equals(other.topicCode))
			return false;
		return true;
	}
}
