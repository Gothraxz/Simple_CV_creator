package gothraxz.Simple.CV.creator.userManagement.homePage.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Controller
@RequestMapping(value = "/Simple_CV_Creator")
public class IndexController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET )
	public String getPersonDetails(Model model) {
		
		return "index";
	}
	
	
	@ModelAttribute("personItems")
	public Collection<Person> getPersonItems(){
		return (Collection<Person>) personService.findAll();
	}
	
}
