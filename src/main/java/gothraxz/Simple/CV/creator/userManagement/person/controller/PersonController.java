package gothraxz.Simple.CV.creator.userManagement.person.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Controller
@RequestMapping(value = "/Simple_CV_Creator/Person_Management")
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
		} else {
			return "person/personAdd";
		}
		
		return "redirect:/Simple_CV_Creator/index";
	}
	
	@RequestMapping(value = "{id}/Details", method = RequestMethod.GET )
	public String getPersonDetails(Model model, @PathVariable long id) {
		
		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("person", person.get());
		}
		
		return "person/personResult";
	}
	
	@RequestMapping(value = "{id}/Edit", method = RequestMethod.GET )
	public String getPersonToEdit(Model model, @PathVariable long id) {

		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("person", person.get());
		}
		
		return "person/personEdit";
	}
	
	@RequestMapping(value = "{id}/Edit", method = RequestMethod.POST )
	public String getPersonToEdit(@Valid @ModelAttribute Person person, BindingResult result, 
			@PathVariable long id) {
		
		if (!result.hasErrors()) {
			personService.save(person);
			return "redirect:/Simple_CV_Creator/index";
		}
		
		return "person/personEdit";
	}
	
	@RequestMapping(value = "{id}/Delete", method = RequestMethod.GET )
	public String getPersonToDelete(Model model, @PathVariable long id) {
		
		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("person", person.get());
		}
		
		return "person/personDelete";
	}
	

	@RequestMapping(value = "{id}/Delete", method = RequestMethod.POST )
	public String getPersonToDelete(@ModelAttribute Person person, @PathVariable long id) {
		personService.deleteById(id);
		
		return "redirect:/Simple_CV_Creator/index";
	}
	
	@ModelAttribute("personItems")
	public Collection<Person> getPersonItems(){
		return (Collection<Person>) personService.findAll();
	}
	
}
