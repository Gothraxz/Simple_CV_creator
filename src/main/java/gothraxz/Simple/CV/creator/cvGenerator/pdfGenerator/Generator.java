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

import gothraxz.Simple.CV.creator.userManagement.address.entity.Address;
import gothraxz.Simple.CV.creator.userManagement.person.dto.PersonDTO;

@Component
public class Generator {

	private static final String DESTINATION_FOLDER = "src/main/resources/public/";

	public void createPdf(PersonDTO personDto) throws IOException {
		if (personDto == null) {
			return;
		}

		String pdfFile = createFile(personDto);
		
		PdfWriter writer = new PdfWriter(pdfFile);

		PdfDocument pdf = new PdfDocument(writer);

		Document document = new Document(pdf);

		document.add(
				new Paragraph("CV")
				.setBackgroundColor(Color.GRAY)
				.setFontColor(Color.WHITE)
				.setFontSize(24)
				.setTextAlignment(TextAlignment.CENTER));
		
		insertSectionParagraph(document, "Personal information:");
		
		insertParagraph(document, "First name: ", personDto.getFirstName());
		insertParagraph(document, "Last name: ", personDto.getLastName());
		insertParagraph(document, "Day of birth: ", personDto.getBirthday().toString());
		insertParagraph(document, "Phone number: ", personDto.getPhonenumber());
		insertParagraph(document, "E-mail: ", personDto.getEmail());
		
		insertSectionParagraph(document, "Address information:");
		
		Address address = personDto.getAddress();
		
		insertParagraph(document, "Postal Code: ", address.getPostalCode());
		insertParagraph(document, "City: ", address.getCity());
		insertParagraph(document, "Street: ", address.getStreet());
		insertParagraph(document, "Address 1: ", address.getBuildingNumber());
		insertParagraph(document, "Address 2: ", address.getDoorNumber());
		
		document.close();
	}
	
	private void insertSectionParagraph(Document document, String label) {

		Paragraph paragraph = new Paragraph();
		Text labelPart = new Text(label)
				.setBold()
				.setUnderline()
				.setFontSize(18);
		paragraph.add(labelPart);
		document.add(paragraph);
		
	}

	private void insertParagraph(Document document, 
			String label, String text) {
		
		Paragraph paragraph = new Paragraph();
		Text labelPart = new Text(label).setBold();
		Text textPart = new Text(text);
		paragraph.add(labelPart).add(textPart);
		document.add(paragraph);
		
	}
	
	private String createFile(PersonDTO personDto) {
		
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
		
		return fileName;
		
	}

}
