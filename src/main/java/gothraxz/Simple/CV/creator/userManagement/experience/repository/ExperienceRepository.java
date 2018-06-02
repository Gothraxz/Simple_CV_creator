package gothraxz.Simple.CV.creator.userManagement.experience.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gothraxz.Simple.CV.creator.userManagement.experience.entity.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

	List<Experience> findAllByPersonId(long id);
	
	List<Experience> findAllByPersonIdOrderByStartDateDesc(long id);
	
}
