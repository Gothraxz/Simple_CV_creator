package gothraxz.Simple.CV.creator.cvGenerator.pdfGenerator;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gothraxz.Simple.CV.creator.userManagement.education.entity.Education;
import gothraxz.Simple.CV.creator.userManagement.experience.entity.Experience;
import gothraxz.Simple.CV.creator.userManagement.person.dto.PersonDTO;
import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorTest {

	@Autowired
	private Generator generator;
	
	@Autowired
	private ModelMapper mapper;
	
	@Before
	public void generateFiles() throws IOException {
		Date currentDate = new Date();
		
		Person person = new Person();
		person.setFirstName("test");
		person.setLastName("file");
		person.setBirthday(currentDate);
		person.setPhonenumber("123456789");
		person.setEmail("t@f.com");
		
		List<Experience> experience = new ArrayList<>();
		person.setExperiences(experience);

		List<Education> education = new ArrayList<>();
		person.setEducation(education);
		
		PersonDTO personDto = mapper.map(person, PersonDTO.class);
		generator.createPdf(personDto);
		generator.createPdf(personDto);
	}
	
	@Test
	public void shouldCheckIfGeneratorCreates2Files() {
		//given
		Path path1 = Paths.get("src/main/resources/public/test_file_CV.pdf");
		Path path2 = Paths.get("src/main/resources/public/test_file(1)_CV.pdf");
		//when
		boolean path1Exists =
		        Files.exists(path1,
		            new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
		System.out.println(path1Exists);
		
		boolean path2Exists =
		        Files.exists(path2,
		            new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
		System.out.println(path2Exists);
		//then
		assertTrue(path1Exists && path2Exists);
	}
	
	@After
	public void deleteTestFiles() {
		
		Path path1 = Paths.get("src/main/resources/public/test_file_CV.pdf");
		Path path2 = Paths.get("src/main/resources/public/test_file(1)_CV.pdf");

		try {
		    Files.delete(path1);
		    Files.delete(path2);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	

}
