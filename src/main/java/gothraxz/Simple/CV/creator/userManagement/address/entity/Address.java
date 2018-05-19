package gothraxz.Simple.CV.creator.userManagement.address.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Size(min = 3, max = 50)
	private String street;
	
	@NotEmpty
	@Size(max = 10)
	private String buildingNumber;

	@Size(max = 10)
	private String doorNumber;
	
	@NotEmpty
	@Pattern(regexp = "^\\d{2}-?\\d{3}$")
	private String postalCode;

	@NotEmpty
	@Size(max = 10)
	private String city;
	
}
