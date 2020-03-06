package com.cmap.rest.webservices.cmaprestfulwebservices.coursetopic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmap.rest.webservices.cmaprestfulwebservices.topic.TopicEntity;

@RestController
@CrossOrigin(origins ="http://cmap.s3-website-ap-southeast-2.amazonaws.com")
public class CourseTopicController {
	@Autowired
	private CourseTopicRepository courseTopicDB;

	@GetMapping("course-topic")
	public boolean getCourseTopic(@RequestParam("data") String courseCode, String topicCode) {
		CourseTopicEntity courseSearch = courseTopicDB.findByCourseCode(courseCode, topicCode);
		if (courseSearch == null) {
			return true;
		}

		return false;
	}

	@PostMapping("add-course-topic")
	public @ResponseBody String addCourseTopic(@RequestBody TopicEntity topicEntity) {
		CourseTopicId newCourseTopicId = new CourseTopicId();
		newCourseTopicId.setCourseCode("C1111");
		newCourseTopicId.setTopicCode(topicEntity.getId());

		CourseTopicEntity newCourseTopic = new CourseTopicEntity();
		newCourseTopic.setCourseTopicId(newCourseTopicId);
		newCourseTopic.setOutcomeLevel(topicEntity.getOutcomeLevel());
		newCourseTopic.setPreReqLevel(topicEntity.getPreReqLevel());

		boolean courseSearch = getCourseTopic("C1111", topicEntity.getId());

		if (courseSearch == true) {
			courseTopicDB.save(newCourseTopic);
			return "Saved";
		} else {
			return "Duplicate Entry";
		}
	}

	@GetMapping("course-topic-level")
	public List<CourseTopicEntity> getCourseTopicList(@RequestParam String courseCode, @RequestParam String topicCode) {
		List<CourseTopicEntity> courseTopicList = courseTopicDB.getCourseTopicLevel(courseCode, topicCode);

		return courseTopicList;
	}

	@PutMapping("update-course-topic")
	public @ResponseBody String updateCourseTopic(@RequestBody TopicEntity topicEntity) {
		String topicCode = topicEntity.getId();
		String preReqLevel = topicEntity.getPreReqLevel();
		String outcomeLevel = topicEntity.getOutcomeLevel();

		CourseTopicEntity courseTopic = courseTopicDB.findByCourseCode("C1111", topicCode);
		courseTopic.setPreReqLevel(preReqLevel);
		courseTopic.setOutcomeLevel(outcomeLevel);

		courseTopicDB.save(courseTopic);

		return "Updated";
	}

	@DeleteMapping("delete-course-topic")
	public @ResponseBody String deleteCourseTopic(@RequestParam String topicCode) {
		CourseTopicEntity courseTopic = courseTopicDB.findByCourseCode("C1111", topicCode);
		courseTopicDB.delete(courseTopic);
		return "Deleted";
	}
}
