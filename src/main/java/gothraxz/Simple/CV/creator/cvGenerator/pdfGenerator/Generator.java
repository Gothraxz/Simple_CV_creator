package gothraxz.Simple.CV.creator.cvGenerator.pdfGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import gothraxz.Simple.CV.creator.userManagement.person.dto.PersonDTO;

@Component
public class Generator {

	private static final String DESTINATION_FOLDER = "src/main/resources/public/";

	public void createPdf(PersonDTO personDto) throws IOException {
		if (personDto == null) {
			return;
		}

		String fileName = DESTINATION_FOLDER 
				+ personDto.getFirstName() 
				+ "_" 
				+ personDto.getLastName()
				+ "_CV.pdf";

		Path path = Paths.get(fileName);
		int counter = 1;
		File file = null;
		while(Files.exists(path)){
		    fileName = DESTINATION_FOLDER 
					+ personDto.getFirstName() 
					+ "_" 
					+ personDto.getLastName() 
					+ "(" + counter
					+ ")_CV.pdf";
		    path = Paths.get(fileName);
		    counter++;
		}
		
		file = new File(fileName);
		file.getParentFile().mkdirs();

		PdfWriter writer = new PdfWriter(fileName);

		PdfDocument pdf = new PdfDocument(writer);

		Document document = new Document(pdf);

		document.add(
				new Paragraph("CV")
				.setBackgroundColor(Color.GRAY)
				.setFontColor(Color.WHITE)
				.setFontSize(24)
				.setTextAlignment(TextAlignment.CENTER));
		
		Paragraph personalInformationParagraph = new Paragraph();
		Text personalInformationLabel = new Text("Personal information: ")
				.setBold()
				.setUnderline()
				.setFontSize(18);
		personalInformationParagraph.add(personalInformationLabel);
		document.add(personalInformationParagraph);
		
		Paragraph firstNameParagraph = new Paragraph();
		Text firstNameLabel = new Text("First name: ").setBold();
		Text firstNameText = new Text(personDto.getFirstName());
		firstNameParagraph.add(firstNameLabel).add(firstNameText);
		document.add(firstNameParagraph);
		
		Paragraph lastNameParagraph = new Paragraph();
		Text lastNameLabel = new Text("Last name: ").setBold();
		Text lastNameText = new Text(personDto.getLastName());
		lastNameParagraph.add(lastNameLabel).add(lastNameText);
		document.add(lastNameParagraph);
		
		Paragraph birthdayParagraph = new Paragraph();
		Text birthdayLabel = new Text("Day of birth: ").setBold();
		Text birthdayText = new Text(personDto.getBirthday().toString());
		birthdayParagraph.add(birthdayLabel).add(birthdayText);
		document.add(birthdayParagraph);
		
		Paragraph phoneNumberParagraph = new Paragraph();
		Text phoneNumberLabel = new Text("Phone number: ").setBold();
		Text phoneNumberText = new Text(personDto.getPhonenumber());
		phoneNumberParagraph.add(phoneNumberLabel).add(phoneNumberText);
		document.add(phoneNumberParagraph);
		
		Paragraph emailParagraph = new Paragraph();
		Text emailLabel = new Text("Email: ").setBold();
		Text emailText = new Text(personDto.getEmail());
		emailParagraph.add(emailLabel).add(emailText);
		document.add(emailParagraph);
		
		
		document.close();
	}

}
