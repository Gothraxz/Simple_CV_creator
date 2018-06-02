package gothraxz.Simple.CV.creator.userManagement.education.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import gothraxz.Simple.CV.creator.userManagement.education.entity.Education;

public interface EducationService {
	
	void save(Education education);

	Optional<Education> findById(long id);
	
	void deleteById(long id);

	Collection<Education> findAll();
	
	List<Education> findAllByPersonId(long id);
	
	List<Education> findAllByPersonIdOrderByStartDateDesc(long id);

}
