package com.cmap.rest.webservices.cmaprestfulwebservices.programcoursebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://cmap.s3-website-ap-southeast-2.amazonaws.com")
public class ProgramCourseBoController {

	@Autowired
	private ProgramCourseBoRepository rmitProgramBoJpaRespository;

	@GetMapping("/allCourseinProgram/{programCode}")
	public List<ProgramCourseBo> getAllCourseinProgram(@PathVariable String programCode) {
		return rmitProgramBoJpaRespository.findAllCourseByProgram(programCode);
	}

}
