package gothraxz.Simple.CV.creator.userManagement.education.controller;

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

import gothraxz.Simple.CV.creator.userManagement.education.entity.Education;
import gothraxz.Simple.CV.creator.userManagement.education.service.EducationService;
import gothraxz.Simple.CV.creator.userManagement.experience.entity.Experience;
import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Controller
@RequestMapping(value = "/Simple_CV_Creator/Education_Management")
public class EducationController {


	@Autowired
	private EducationService educationService;
	
	@Autowired
	private PersonService personService;

	@GetMapping(value = "/Main")
	public String educationMainPage(Model model) {
		return "education/educationMain";
	}
	
	@GetMapping(value = "{personId}/Create")
	public String createEducationForm(Model model, @PathVariable long personId) {
		model.addAttribute("education", new Education());
		return "education/educationAdd";
	}
	
	@PostMapping(value = "{personId}/Create")
	public String createEducationForm(@Valid @ModelAttribute Education education, BindingResult result,
			@PathVariable long personId) {
		
		if(!result.hasErrors()) {
			
			Optional<Person> person = personService.findById(personId);
			if(person.isPresent()) {
				education.setPerson(person.get());
				educationService.save(education);				
			}
			
		} else {
			return "education/educationAdd";
		}
		
		return "redirect:/Simple_CV_Creator/index";
	}
	
	@GetMapping(value = "{personId}/Details")
	public String educationDetails(Model model, @PathVariable long personId) {
		
		Optional<Person> person = personService.findById(personId);
		if(person.isPresent()) {
			model.addAttribute("education", person.get().getEducation());				
		}
		
		return "education/educationResult";
	}
	
	@GetMapping(value = "{personId}/Edit/{id}")
	public String editEducation(Model model, @PathVariable long personId, @PathVariable long id) {

		Optional<Person> person = personService.findById(personId);
		Optional<Education> education = educationService.findById(id);
		
		if(person.isPresent() && education.isPresent()) {
			if (person.get().getEducation().contains(education.get())) {
				model.addAttribute("education", education);
			}
		}

		return "education/educationEdit";
	}
	
	@PostMapping(value = "{personId}/Edit/{id}")
	public String editEducation(@Valid @ModelAttribute Education education, 
			BindingResult result, 
			@PathVariable long personId) {

		if (!result.hasErrors()) {
			Optional<Person> person = personService.findById(personId);
			if(person.isPresent()) {
				education.setPerson(person.get());
				educationService.save(education);				
			}
			return "redirect:/Simple_CV_Creator/index";
		}
		
		return "education/educationEdit";
	}
	
	@GetMapping(value = "{personId}/Delete/{id}")
	public String deleteEducation(Model model, @PathVariable long personId,
			@PathVariable long id) {
		
		Optional<Person> person = personService.findById(personId);
		Optional<Education> education = educationService.findById(id);
		
		if (person == null || education == null) {
			return "error/wrongPathVariable";
		}
		
		if(person.isPresent() && education.isPresent()) {
			if (person.get().getEducation().contains(education.get())) {
				model.addAttribute("education", education.get());
			}
		}
		
		return "education/educationDelete";
	}
	

	@PostMapping(value = "{personId}/Delete/{id}")
	public String deleteEducation(@ModelAttribute Education education, 
			@PathVariable long personId, 
			@PathVariable long id) {

		Optional<Person> person = personService.findById(personId);
		Optional<Education> edu = educationService.findById(education.getId());
		
		if(person.isPresent() && edu.isPresent()) {
			educationService.deleteById(id);
		}
		
		return "redirect:/Simple_CV_Creator/index";
	}
	
	@ModelAttribute("personItems")
	public Collection<Person> getPersonItems(){
		return (Collection<Person>) personService.findAll();
	}

	@ModelAttribute("educationItems")
	public Collection<Education> getEducationItems(){
		return (Collection<Education>) educationService.findAll();
	}
	
}
