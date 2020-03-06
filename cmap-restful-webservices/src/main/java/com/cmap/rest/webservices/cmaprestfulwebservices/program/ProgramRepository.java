package com.cmap.rest.webservices.cmaprestfulwebservices.program;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity,ProgramId> {
	List<ProgramEntity> findByProgramID(ProgramId programID);
}
