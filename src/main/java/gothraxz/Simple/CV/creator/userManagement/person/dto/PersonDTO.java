package gothraxz.Simple.CV.creator.userManagement.person.dto;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import gothraxz.Simple.CV.creator.userManagement.address.entity.Address;
import gothraxz.Simple.CV.creator.userManagement.experience.entity.Experience;
import gothraxz.Simple.CV.creator.userManagement.person.service.PersonService;

@Component
public class PersonDTO {
	
	private long id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String phonenumber;
	private String email;
	private Address address;
	private List<Experience> experiences;
	
	public PersonDTO() {
		
	}
	
	public PersonDTO(long id) {
		this.id = id;
	}

	public PersonDTO(PersonService personService, long id, String firstName, String lastName, Date birthday,
			String phonenumber, String email, Address address, List<Experience> experiences) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.phonenumber = phonenumber;
		this.email = email;
		this.address = address;
		this.experiences = experiences;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

}
