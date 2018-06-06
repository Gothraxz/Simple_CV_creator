# Simple_CV_creator
Simple CV creator - PDF file

This simple program can generate PDF file based on provided data. 
It was design to be used in small recruitment agency, therefore, first module loads data from database.
Application uses Spring Boot, Hibernate, MySQL, JPA, relations between entities, JSP, bootstrap 4, JUnit and IText7.

Current version funcionality:

	- Personal data management (CRUD) - core,
	- Address data management (CRUD) - optional,
	- Education data management (CRUD) - optional,
	- Experience data management (CRUD) - optional,
	- Generate PDF file based on provided sections (listed above, empty section are skipped),
	- Custom error pages for 403, 404 & 500 codes,
	- filename iteration (to prevent overwriting existing files),
	- form validation,

Planned funcionality:

	- Spring Security,
	- Possibility to create CV from user perspective,
	- PDF file downloading,
	- More styles,
	- Possibility to customize selected syle (in limited way),
	- Reporting module (find person by experience / education, company name, city etc),
	- Generate multiple CVs based on report,
	- Possibility to send CVs by e-mail,
	- Optimization of links / ui,
	- fully responsive layout
