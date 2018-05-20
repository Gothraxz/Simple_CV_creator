package gothraxz.Simple.CV.creator.cvGenerator;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gothraxz.Simple.CV.creator.userManagement.person.dto.PersonDTO;
import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Component
public class UserManagementFacade {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PersonDTO getPersonById(long id) {
		Optional<Person> person = personService.findById(id);
		if (person.isPresent()) {
			return modelMapper.map(person.get(), PersonDTO.class);
		} else {
			return null;
		}
	}
	
}
