package gothraxz.Simple.CV.creator.userManagement.address.controller;

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

import gothraxz.Simple.CV.creator.userManagement.address.entity.Address;
import gothraxz.Simple.CV.creator.userManagement.address.service.AddressService;
import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Controller
@RequestMapping(value = "/Simple_CV_Creator/Address_Management")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private PersonService personService;

	@GetMapping(value = "/Main")
	public String addressMainPage(Model model) {
		return "address/addressMain";
	}
	
	@GetMapping(value = "{id}/Create")
	public String createAddressForm(Model model, @PathVariable long id) {
		model.addAttribute("address", new Address());
		return "address/addressAdd";
	}
	
	@PostMapping(value = "{id}/Create")
	public String createAddressForm(@Valid @ModelAttribute Address address, BindingResult result,
			@PathVariable long id) {
		
		if(!result.hasErrors()) {
			
			Optional<Person> person = personService.findById(id);
			if(person.isPresent()) {
				address.setPerson(person.get());
				addressService.save(address);				
			}
			
		} else {
			return "address/addressAdd";
		}
		
		return "redirect:/Simple_CV_Creator/Address_Management/Main";
	}
	
	@GetMapping(value = "{id}/Details")
	public String addressDetails(Model model, @PathVariable long id) {
		
		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("address", person.get().getAddress());				
		}
		
		return "address/addressResult";
	}
	
	@GetMapping(value = "{id}/Edit")
	public String editAddress(Model model, @PathVariable long id) {

		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("address", person.get().getAddress());				
		}

		return "address/addressEdit";
	}
	
	@PostMapping(value = "{id}/Edit")
	public String editAddress(@Valid @ModelAttribute Address address, BindingResult result, 
			@PathVariable long id) {

		if (!result.hasErrors()) {
			Optional<Person> person = personService.findById(id);
			if(person.isPresent()) {
				address.setPerson(person.get());
				addressService.save(address);				
			}
			return "redirect:/Simple_CV_Creator/Address_Management/Main";
		}
		
		return "address/addressEdit";
	}
	
	@GetMapping(value = "{id}/Delete")
	public String deleteAddress(Model model, @PathVariable long id) {
		
		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			model.addAttribute("address", person.get().getAddress());				
		}
		
		return "address/addressDelete";
	}
	

	@PostMapping(value = "{id}/Delete")
	public String deleteAddress(@ModelAttribute Address address, @PathVariable long id) {

		Optional<Person> person = personService.findById(id);
		if(person.isPresent()) {
			long addressId = person.get().getAddress().getId();
			person.get().setAddress(null);
			addressService.deleteById(addressId);				
		}
		
		return "redirect:/Simple_CV_Creator/Address_Management/Main";
	}
	
	@ModelAttribute("personItems")
	public Collection<Person> getPersonItems(){
		return (Collection<Person>) personService.findAll();
	}

	@ModelAttribute("addressItems")
	public Collection<Address> getAddressItems(){
		return (Collection<Address>) addressService.findAll();
	}
	
}
