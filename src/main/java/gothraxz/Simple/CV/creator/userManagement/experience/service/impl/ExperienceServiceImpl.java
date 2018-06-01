package gothraxz.Simple.CV.creator.userManagement.experience.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gothraxz.Simple.CV.creator.userManagement.experience.entity.Experience;
import gothraxz.Simple.CV.creator.userManagement.experience.repository.ExperienceRepository;
import gothraxz.Simple.CV.creator.userManagement.experience.service.ExperienceService;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Override
	public void save(Experience experience) {
		experienceRepository.save(experience);
	}

	@Override
	public Optional<Experience> findById(long id) {
		Optional<Experience> experience = experienceRepository.findById(id);
		if(experience.isPresent()) {
			return experience;
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		experienceRepository.deleteById(id);
		
	}

	@Override
	public Collection<Experience> findAll() {
		return experienceRepository.findAll();
	}

	@Override
	public List<Experience> findAllByPersonId(long id) {
		return experienceRepository.findAllByPersonId(id);
	}
	
}
