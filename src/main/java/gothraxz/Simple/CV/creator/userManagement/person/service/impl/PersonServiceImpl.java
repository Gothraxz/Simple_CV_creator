package gothraxz.Simple.CV.creator.userManagement.person.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.repository.PersonRepository;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;

	@Override
	public void save(Person person) {
		personRepository.save(person);
	}

	@Override
	public Optional<Person> findById(long id) {
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()) {
			return person;
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		personRepository.deleteById(id);
	}

	@Override
	public Collection<Person> findAll() {
		return personRepository.findAll();
	}
	
	
	
}
