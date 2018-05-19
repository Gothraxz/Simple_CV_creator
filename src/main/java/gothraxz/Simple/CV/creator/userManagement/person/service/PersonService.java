package gothraxz.Simple.CV.creator.userManagement.person.service;

import java.util.Optional;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;

public interface PersonService {

	void save(Person person);

	Optional findById(long id);
	
	void deleteById(long id);
	
}