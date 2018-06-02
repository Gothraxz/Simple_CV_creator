package gothraxz.Simple.CV.creator.userManagement.education.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;

@Entity
public class Education implements Comparable<Education> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@Past
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@NotBlank
	private String schoolName;
	
	@NotBlank
	@Size(min = 3, max = 25, message = "{size.education.city}")
	private String city;
	
	@NotBlank
	private String grade;
	
	@NotBlank
	private String direction;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date start) {
		this.startDate = start;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date end) {
		this.endDate = end;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String companyName) {
		this.schoolName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String jobTitle) {
		this.grade = jobTitle;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String taskDescription) {
		this.direction = taskDescription;
	}

	@Override
	public int compareTo(Education o) {
		return getStartDate().compareTo(o.getStartDate());
	}
	
}
