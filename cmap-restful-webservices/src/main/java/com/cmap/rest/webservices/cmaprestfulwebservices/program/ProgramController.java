package com.cmap.rest.webservices.cmaprestfulwebservices.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://cmap.s3-website-ap-southeast-2.amazonaws.com")
public class ProgramController {
	@Autowired
	private ProgramRepository rmitProgramJpaRespository;

	@GetMapping("/code/{code}/year/{year}")
	public List<ProgramEntity> getOneProgramTodo(@PathVariable String code, @PathVariable int year) {
		ProgramId programId = new ProgramId("BP094GEN8", 2018);

		return rmitProgramJpaRespository.findByProgramID(programId);
	}

}
