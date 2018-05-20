package gothraxz.Simple.CV.creator.cvGenerator.pdfGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

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

		document.add(new Paragraph("CV"));
		document.add(new Paragraph(personDto.getFullName()));

		document.close();
	}

}
