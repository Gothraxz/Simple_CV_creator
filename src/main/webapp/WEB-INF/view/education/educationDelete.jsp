<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Education information - clear</title>
</head>
<body>

	<h1>Delete education:</h1>
	
<!-- TODO person name  -->
		Start Date: <c:out value = "${education.startDate}"/><br>
		End Date: <c:out value = "${education.endDate}"/><br>
		School / University Name: <c:out value = "${education.schoolName}"/><br>
		City: <c:out value = "${education.city}"/><br>
		Grade: <c:out value = "${education.grade}"/><br>
		Direction: <c:out value = "${education.direction}"/><br>
		<br>
		
	Please confirm:
	<form:form method="POST" modelAttribute="education">
	<button type="submit">Yes</button>
	</form:form>

	<a href="/Simple_CV_Creator/index"> <button>No</button> </a>

</body>
</html>