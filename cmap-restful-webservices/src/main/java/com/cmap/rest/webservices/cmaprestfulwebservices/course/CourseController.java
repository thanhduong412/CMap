package com.cmap.rest.webservices.cmaprestfulwebservices.course;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://cmap.s3-website-ap-southeast-2.amazonaws.com")
public class CourseController {
	@Autowired
	private CourseRepository courseRepo;

	@GetMapping("/{courseCode}")
	public List<CourseEntity> getCourseTodo(@PathVariable String courseCode) {
		return courseRepo.findByCourseCode(courseCode);
	}
	
	@GetMapping("/courses-not-in-program/{programCode}")
	public List<CourseEntity> getAllCourse(@PathVariable String programCode){
		return courseRepo.findAllCourseNotInProgram(programCode);
	}

}
