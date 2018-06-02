package gothraxz.Simple.CV.creator.userManagement.education.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gothraxz.Simple.CV.creator.userManagement.education.entity.Education;
import gothraxz.Simple.CV.creator.userManagement.education.repository.EducationRepository;
import gothraxz.Simple.CV.creator.userManagement.education.service.EducationService;
import gothraxz.Simple.CV.creator.userManagement.experience.entity.Experience;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepository;
	
	@Override
	public void save(Education education) {
		educationRepository.save(education);
	}

	@Override
	public Optional<Education> findById(long id) {
		Optional<Education> education = educationRepository.findById(id);
		if(education.isPresent()) {
			return education;
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		educationRepository.deleteById(id);
		
	}

	@Override
	public Collection<Education> findAll() {
		return educationRepository.findAll();
	}

	@Override
	public List<Education> findAllByPersonId(long id) {
		return educationRepository.findAllByPersonId(id);
	}

	@Override
	public List<Education> findAllByPersonIdOrderByStartDateDesc(long id) {
		return educationRepository.findAllByPersonIdOrderByStartDateDesc(id);
	}
	
}
