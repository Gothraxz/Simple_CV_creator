<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Experience information - clear</title>
</head>
<body>

	<h1>Delete experience:</h1>
	
<!-- TODO person name  -->
		Start Date: <c:out value = "${experience.startDate}"/><br>
		End Date: <c:out value = "${experience.endDate}"/><br>
		Company Name: <c:out value = "${experience.companyName}"/><br>
		City: <c:out value = "${experience.city}"/><br>
		Job Title: <c:out value = "${experience.jobTitle}"/><br>
		Task Description: <c:out value = "${experience.taskDescription}"/><br>
		<br>
		
	Please confirm:
	<form:form method="POST" modelAttribute="experience">
	<button type="submit">Yes</button>
	</form:form>

	<a href="/Simple_CV_Creator/index"> <button>No</button> </a>

</body>
</html>