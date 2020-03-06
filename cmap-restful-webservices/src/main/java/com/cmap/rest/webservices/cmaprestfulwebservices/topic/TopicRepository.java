package com.cmap.rest.webservices.cmaprestfulwebservices.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, String> {
	@Query(value ="SELECT std_guidelines.name, std_ka.ka_title, std_ku.ku_title, std_topic.topic_code, std_topic.title, std_topic.level, std_topic.requirement\r\n" + 
			"			FROM std_guidelines, std_ka, std_ku, std_topic\r\n" + 
			"			WHERE std_topic.topic_code \r\n" + 
			"            NOT IN(SELECT topic_code \r\n" + 
			"            FROM cmap.rmit_course_topic\r\n" + 
			"            WHERE course_code = \"C1111\")\r\n" + 
			"            AND std_topic.ku = std_ku.ku_code \r\n" + 
			"			AND std_ku.ka = std_ka.ka_code\r\n" + 
			"			AND std_ka.id_guidelines = std_guidelines.id;", nativeQuery = true)
	List<TopicEntity> getTopicList();
	
	@Query(value = "SELECT std_guidelines.name, std_ka.ka_title, std_ku.ku_title, rmit_course_topic.topic_code, std_topic.title, rmit_course_topic.level, rmit_course_topic.requirement\r\n"
			+ "FROM std_guidelines, std_ka, std_ku, std_topic, rmit_course_topic\r\n"
			+ "WHERE rmit_course_topic.course_code = ?1 \r\n"
			+ "AND rmit_course_topic.topic_code = std_topic.topic_code\r\n"
			+ "AND std_topic.ku = std_ku.ku_code\r\n" 
			+ "AND std_ku.ka = std_ka.ka_code\r\n"
			+ "AND std_ka.id_guidelines = std_guidelines.id;", nativeQuery = true)
	List<TopicEntity> getCourseTopicDetails(String courseCode);
}
