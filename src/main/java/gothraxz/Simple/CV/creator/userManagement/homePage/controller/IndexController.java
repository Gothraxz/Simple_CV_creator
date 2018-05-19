package gothraxz.Simple.CV.creator.userManagement.homePage.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.repository.PersonRepository;

@Controller
@RequestMapping(value = "/Simple_CV_Creator")
public class IndexController {

	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET )
	public String getPersonDetails(Model model) {
		
		return "index";
	}
	
	@ModelAttribute("personDetails")
	public Optional<Person> getAuthorItems(){
		Optional<Person> personDetails = personRepository.findById(1L);
		if(personDetails.isPresent()) {
			return personDetails;
		}
		return null;
	}
	
}
