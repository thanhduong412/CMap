package com.cmap.rest.webservices.cmaprestfulwebservices.coursetopic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseTopicRepository extends JpaRepository<CourseTopicEntity, Integer> {

	@Query(value="SELECT * FROM rmit_course_topic WHERE course_code =?1 AND topic_code =?2", nativeQuery = true)
	CourseTopicEntity findByCourseCode(String courseCode, String topicCode);
	
	@Query(value="SELECT *\n" + 
            "FROM rmit_course_topic\n" + 
            "WHERE rmit_course_topic.course_code = ?1\n" +
            "AND rmit_course_topic.topic_code = ?2", nativeQuery = true)
	List<CourseTopicEntity> getCourseTopicLevel(String courseCode, String topicCode);
}


