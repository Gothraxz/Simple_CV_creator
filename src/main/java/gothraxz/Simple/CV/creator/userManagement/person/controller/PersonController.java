package gothraxz.Simple.CV.creator.userManagement.person.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Controller
@RequestMapping(value = "/Simple_CV_Creator")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/Create", method = RequestMethod.GET )
	public String getPersonForm(Model model) {
		model.addAttribute("person", new Person());
		return "person/personAdd";
	}
	
	@RequestMapping(value = "/Create", method = RequestMethod.POST )
	public String getPersonForm(@Valid @ModelAttribute Person person, BindingResult result) {
		
		if(!result.hasErrors()) {
			personService.save(person);
		}
		
		return "person/personAdd";
	}
	
	@RequestMapping(value = "/Details", method = RequestMethod.GET )
	public String getPersonDetails(Model model) {
		
		return "person/personResult";
	}
	
	@RequestMapping(value = "/Edit", method = RequestMethod.GET )
	public String getPersonToEdit(Model model) {
		model.addAttribute("person", personService.findById(1L));
		
		return "peron/personEdit";
	}
	
	@RequestMapping(value = "/Edit", method = RequestMethod.POST )
	public String getPersonToEdit(@Valid @ModelAttribute Person person, BindingResult result) {
		
		if (!result.hasErrors()) {
			personService.save(person);
			return "redirect:/personResult";
		}
		
		return "person/personEdit";
	}
	
	@RequestMapping(value = "/Clear", method = RequestMethod.GET )
	public String getPersonToDelete(Model model) {
		model.addAttribute("person", personService.findById(1L));
		
		return "person/personDelete";
	}
	

	@RequestMapping(value = "/Clear", method = RequestMethod.POST )
	public String getPersonToDelete(@ModelAttribute Person person) {
		personService.deleteById(1L);
		
		return "redirect:/index";
	}
	
	@ModelAttribute("personDetails")
	public Optional<Person> getAuthorItems(){
		Optional<Person> personDetails = personService.findById(1L);
		if(personDetails.isPresent()) {
			return personDetails;
		}
		return null;
	}
	
}
