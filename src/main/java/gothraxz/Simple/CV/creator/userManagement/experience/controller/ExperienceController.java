package gothraxz.Simple.CV.creator.userManagement.experience.controller;

import java.util.Collection;
import java.util.List;
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

import gothraxz.Simple.CV.creator.userManagement.experience.entity.Experience;
import gothraxz.Simple.CV.creator.userManagement.experience.service.ExperienceService;
import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Controller
@RequestMapping(value = "/Simple_CV_Creator/Experience_Management")
public class ExperienceController {


	@Autowired
	private ExperienceService experienceService;
	
	@Autowired
	private PersonService personService;

	@GetMapping(value = "/Main")
	public String experienceMainPage(Model model) {
		return "experience/experienceMain";
	}
	
	@GetMapping(value = "{id}/Create")
	public String createExperienceForm(Model model, @PathVariable long id) {
		model.addAttribute("experience", new Experience());
		return "experience/experienceAdd";
	}
	
	@PostMapping(value = "{id}/Create")
	public String createExperienceForm(@Valid @ModelAttribute Experience experience, BindingResult result,
			@PathVariable long id) {
		
		if(!result.hasErrors()) {
			
			Optional<Person> person = personService.findById(id);
			if(person.isPresent()) {
				experience.setPerson(person.get());
				experienceService.save(experience);				
			}
			
		} else {
			return "experience/experienceAdd";
		}
		
		return "redirect:/Simple_CV_Creator/index";
	}
	
	@GetMapping(value = "{id}/Details")
	public String experienceDetails(Model model, @PathVariable long id) {
		
		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("experience", person.get().getExperience());				
		}
		
		return "experience/experienceResult";
	}
	
	@GetMapping(value = "{id}/Edit")
	public String editExperience(Model model, @PathVariable long id) {

		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("experience", person.get().getExperience());				
		}

		return "experience/experienceEdit";
	}
	
	@PostMapping(value = "{id}/Edit")
	public String editExperience(@Valid @ModelAttribute Experience experience, BindingResult result, 
			@PathVariable long id) {

		if (!result.hasErrors()) {
			Optional<Person> person = personService.findById(id);
			if(person.isPresent()) {
				experience.setPerson(person.get());
				experienceService.save(experience);				
			}
			return "redirect:/Simple_CV_Creator/index";
		}
		
		return "experience/experienceEdit";
	}
	
	@GetMapping(value = "{id}/Delete")
	public String deleteExperience(Model model, @PathVariable long id) {
		
		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("experience", person.get().getExperience());				
		}
		
		return "experience/experienceDelete";
	}
	

	@PostMapping(value = "{id}/Delete")
	public String deleteExperience(@ModelAttribute Experience experience, @PathVariable long id) {

		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			List<Experience> experiences = person.get().getExperience();
			person.get().setExperience(null);
			
			for (Experience exp : experiences) {
				experienceService.deleteById(exp.getId());
			}
							
		}
		
		return "redirect:/Simple_CV_Creator/index";
	}
	
	@ModelAttribute("personItems")
	public Collection<Person> getPersonItems(){
		return (Collection<Person>) personService.findAll();
	}

	@ModelAttribute("experienceItems")
	public Collection<Experience> getExperienceItems(){
		return (Collection<Experience>) experienceService.findAll();
	}
	
}
