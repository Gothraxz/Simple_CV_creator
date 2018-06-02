package gothraxz.Simple.CV.creator.userManagement.education.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gothraxz.Simple.CV.creator.userManagement.education.entity.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {

	List<Education> findAllByPersonId(long id);
	
	List<Education> findAllByPersonIdOrderByStartDateDesc(long id);
	
}
