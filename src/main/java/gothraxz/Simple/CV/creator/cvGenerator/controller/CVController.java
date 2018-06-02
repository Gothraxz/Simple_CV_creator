package gothraxz.Simple.CV.creator.cvGenerator.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import gothraxz.Simple.CV.creator.cvGenerator.UserManagementFacade;
import gothraxz.Simple.CV.creator.cvGenerator.pdfGenerator.Generator;
import gothraxz.Simple.CV.creator.userManagement.person.dto.PersonDTO;

@Controller
@RequestMapping(value = "/Simple_CV_Creator")
public class CVController {

	@Autowired
	private UserManagementFacade userManagementFacade;

	@Autowired
	private Generator generator;

	@GetMapping(value = "Person_Management/{id}/CV")
	public String getCvPreview(Model model, @PathVariable long id) {
		model.addAttribute("personDto", userManagementFacade.getPersonById(id));

		return "cv/cv";
	}

	@GetMapping(value = "Person_Management/{id}/CV/success")
	public String getCvFile(Model model, @PathVariable long id) {

		PersonDTO personDto = userManagementFacade.getPersonById(id);
		if(personDto == null) {
			return "cv/missing";
		}

		try {
			generator.createPdf(personDto);
		} catch (IOException e) {
			
			//TODO error site
			e.printStackTrace();
		}

		model.addAttribute("personDto", personDto);
		return "cv/success";
	}

}
