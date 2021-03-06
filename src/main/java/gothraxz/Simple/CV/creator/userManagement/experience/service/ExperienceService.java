package gothraxz.Simple.CV.creator.userManagement.experience.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import gothraxz.Simple.CV.creator.userManagement.experience.entity.Experience;

public interface ExperienceService {
	
	void save(Experience experience);

	Optional<Experience> findById(long id);
	
	void deleteById(long id);

	Collection<Experience> findAll();
	
	List<Experience> findAllByPersonId(long id);
	
	List<Experience> findAllByPersonIdOrderByStartDateDesc(long id);

}
