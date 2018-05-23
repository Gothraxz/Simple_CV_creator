package gothraxz.Simple.CV.creator.userManagement.person.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Controller
@RequestMapping(value = "/Simple_CV_Creator/Person_Management")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "/Create")
	public String createPersonForm(Model model) {
		model.addAttribute("person", new Person());
		return "person/personAdd";
	}
	
	@PostMapping(value = "/Create")
	public String createPersonForm(@Valid @ModelAttribute Person person, BindingResult result) {
		
		if(!result.hasErrors()) {
			personService.save(person);
		} else {
			return "person/personAdd";
		}
		
		return "redirect:/Simple_CV_Creator/index";
	}
	
	@GetMapping(value = "{id}/Details")
	public String personDetails(Model model, @PathVariable long id) {
		
		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("person", person.get());
		}
		
		return "person/personResult";
	}
	
	@GetMapping(value = "{id}/Edit")
	public String editPerson(Model model, @PathVariable long id) {

		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("person", person.get());
		}
		
		return "person/personEdit";
	}
	
	@PostMapping(value = "{id}/Edit")
	public String editPerson(@Valid @ModelAttribute Person person, BindingResult result, 
			@PathVariable long id) {
		
		if (!result.hasErrors()) {
			personService.save(person);
			return "redirect:/Simple_CV_Creator/index";
		}
		
		return "person/personEdit";
	}
	
	@GetMapping(value = "{id}/Delete")
	public String deletePerson(Model model, @PathVariable long id) {
		
		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("person", person.get());
		}
		
		return "person/personDelete";
	}
	

	@PostMapping(value = "{id}/Delete")
	public String deletePerson(@ModelAttribute Person person, @PathVariable long id) {
		personService.deleteById(id);
		
		return "redirect:/Simple_CV_Creator/index";
	}
	
	@ModelAttribute("personItems")
	public Collection<Person> getPersonItems(){
		return (Collection<Person>) personService.findAll();
	}
	
}
