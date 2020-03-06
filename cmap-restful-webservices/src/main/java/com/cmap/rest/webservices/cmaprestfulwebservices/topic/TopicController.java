package com.cmap.rest.webservices.cmaprestfulwebservices.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://cmap.s3-website-ap-southeast-2.amazonaws.com")
public class TopicController {
	@Autowired
	private TopicRepository topicDB;
	
	@GetMapping("topic-list")
	public List<TopicEntity> getTopicList(){
		return topicDB.getTopicList();
	}
	
	@GetMapping("course-topic-details")
	public List<TopicEntity> getTopic(@RequestParam String courseCode) {
		return topicDB.getCourseTopicDetails(courseCode);
	}
}
