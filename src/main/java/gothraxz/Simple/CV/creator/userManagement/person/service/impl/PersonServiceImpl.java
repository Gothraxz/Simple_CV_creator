package gothraxz.Simple.CV.creator.userManagement.person.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.repository.PersonRepository;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;

	@Override
	public void save(Person person) {
		personRepository.save(person);
	}

	@Override
	public Optional<Person> findById(long id) {
		Optional<Person> person = personRepository.findById(1L);
		if(person.isPresent()) {
			return person;
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		personRepository.deleteById(id);
	}
	
	
	
}
