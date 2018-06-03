package gothraxz.Simple.CV.creator.cvGenerator.pdfGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

import gothraxz.Simple.CV.creator.userManagement.address.entity.Address;
import gothraxz.Simple.CV.creator.userManagement.education.entity.Education;
import gothraxz.Simple.CV.creator.userManagement.experience.entity.Experience;
import gothraxz.Simple.CV.creator.userManagement.person.dto.PersonDTO;

@Component
public class Generator {

	private static final String DESTINATION_FOLDER = "src/main/resources/public/";
	
	private static final String LEGAL_AGREEMENT = "I hereby give consent for my personal data " 
			+ "included in my application to be processed for the purposes " 
			+ "of the recruitment process under the Personal Data Protection Act " 
			+ "as of 29 August 1997, consolidated text: Journal of Laws 2016, item 922 as amended.";

	public void createPdf(PersonDTO personDto) throws IOException {
		if (personDto == null) {
			return;
		}

		String pdfFile = createFile(personDto);
		
		PdfWriter writer = new PdfWriter(pdfFile);

		PdfDocument pdf = new PdfDocument(writer);

		Document document = new Document(pdf, PageSize.A4);

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
		
		Address address = personDto.getAddress();		
		
		if (address != null) {
			
			insertSectionParagraph(document, "Address information:");
			
			insertParagraph(document, "Postal Code: ", address.getPostalCode());
			insertParagraph(document, "City: ", address.getCity());
			insertParagraph(document, "Street: ", address.getStreet());
			insertParagraph(document, "Address 1: ", address.getBuildingNumber());
			insertParagraph(document, "Address 2: ", address.getDoorNumber());
			
		}
		
		List<Education> education = personDto.getEducation();
		
		if (!education.isEmpty()) {
			
			insertSectionParagraph(document, "Education:");
			
			insertEducationTable(document, education);
			
		}

		List<Experience> experience = personDto.getExperiences();
		
		if (!experience.isEmpty()) {
			
			insertSectionParagraph(document, "Experience:");
			
			insertExperienceTable(document, experience);
			
		}
		
		document.add(
				new Paragraph(LEGAL_AGREEMENT)
				.setBackgroundColor(Color.GRAY)
				.setFontColor(Color.WHITE)
				.setFontSize(6)
				.setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.BOTTOM));
		
		document.close();
	}
	
	private void insertEducationTable (Document document, List<Education> education) {
		
		Table table = new Table (UnitValue.createPercentArray(new float[]{30,35,35}));
		table.setWidth(UnitValue.createPercentValue(100));
		
		table.addHeaderCell(new Cell().add("Period:")
				.setBorder(Border.NO_BORDER).setBold());
		table.addHeaderCell(new Cell().add("School / University:")
				.setBorder(Border.NO_BORDER).setBold());
		table.addHeaderCell(new Cell().add("Description:")
				.setBorder(Border.NO_BORDER).setBold());
		
		for (Education edu : education) {
			String startDate;
			String endDate;
			
			if (edu.getStartDate() == null) {
				startDate = "N/A";
			} else {
				startDate = edu.getStartDate().toString();
			}
			
			if (edu.getEndDate() == null) {
				endDate = "present";
			} else {
				endDate = edu.getEndDate().toString();
			}
			
			String school = edu.getSchoolName()
					+ "\n" 
					+ edu.getCity(); 
			
			String details = edu.getDirection() 
					+ "\n" 
					+ edu.getGrade();
			
			table.addCell(new Cell().add(startDate + "\n - \n" + endDate)
					.setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(school)
					.setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(details)
					.setBorder(Border.NO_BORDER));
			
		}
		
		document.add(table);
		
	}
	
	private void insertExperienceTable (Document document, List<Experience> experience) {
		
		Table table = new Table (UnitValue.createPercentArray(new float[]{30,30,40}));
		table.setWidth(UnitValue.createPercentValue(100));
		
		table.addHeaderCell(new Cell().add("Period:")
				.setBorder(Border.NO_BORDER).setBold());
		table.addHeaderCell(new Cell().add("Company:")
				.setBorder(Border.NO_BORDER).setBold());
		table.addHeaderCell(new Cell().add("Description:")
				.setBorder(Border.NO_BORDER).setBold());
		
		for (Experience exp : experience) {
			String startDate;
			String endDate;
			
			if (exp.getStartDate() == null) {
				startDate = "N/A";
			} else {
				startDate = exp.getStartDate().toString();
			}
			
			if (exp.getEndDate() == null) {
				endDate = "present";
			} else {
				endDate = exp.getEndDate().toString();
			}
			
			String company = exp.getCompanyName() 
					+ "\n" 
					+ exp.getCity() 
					+ "\n" 
					+ exp.getJobTitle();
			
			String taskDescription = exp.getTaskDescription();
			
			table.addCell(new Cell().add(startDate + "\n - \n" + endDate)
					.setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(company)
					.setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(taskDescription)
					.setBorder(Border.NO_BORDER));
			
		}
		
		document.add(table);
		
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
