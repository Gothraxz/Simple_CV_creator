package gothraxz.Simple.CV.creator.cvGenerator.pdfGenerator;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gothraxz.Simple.CV.creator.userManagement.person.dto.PersonDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorTest {

	@Autowired
	private Generator generator; 
	
	@Test
	public void testCreatePdf() throws IOException {
		//given
		PersonDTO personDto = new PersonDTO();
		personDto.setFirstName("test");
		personDto.setLastName("file");
		//when
		generator.createPdf(personDto);
		//then
		//TODO check if file exists, read pdf content, delete file
	}

}
