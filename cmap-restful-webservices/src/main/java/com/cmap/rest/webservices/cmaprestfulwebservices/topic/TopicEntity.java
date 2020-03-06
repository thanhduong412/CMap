package com.cmap.rest.webservices.cmaprestfulwebservices.topic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name= "std_topic")
@SecondaryTables({
	@SecondaryTable(name="std_ku"),
	@SecondaryTable(name="std_ka"),
	@SecondaryTable(name="std_guidelines")
})
public class TopicEntity {
	@Id
	@Column(name = "topic_code")
	public String id;
	
	@Column(name = "name", table="std_guidelines")
	public String bokRef;
	
	@Column(name ="ka_title", table="std_ka")
	public String area;
	
	@Column(name = "ku_title", table="std_ku")
	public String unit;
	
	@Column(name = "title")
	public String topic;
	
	@Column(name = "level")
	public String outcomeLevel;
	
	@Column(name = "requirement")
	public String preReqLevel;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBokRef() {
		return bokRef;
	}

	public void setBokRef(String bokRef) {
		this.bokRef = bokRef;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TopicEntity other = (TopicEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
