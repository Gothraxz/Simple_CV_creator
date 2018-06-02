<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Education information - create</title>
</head>
<body>

	<span>
		<a href="/Simple_CV_Creator/index"> <button>Return to main page</button> </a>
	</span>

	<h1>Please add education details:</h1>
	
	<form:form method="POST" modelAttribute="education">
	<%-- Person: <form:select path="person" items="${personItems}" multiple="false" 
	itemValue="id" itemLabel="fullName"/>
	<form:errors path="fullName" /> --%>
	Start Date: <form:input path="startDate"/>
	<form:errors path="startDate" />
	<br>
	End Date: <form:input path="endDate"/>
	<form:errors path="endDate" />
	<br>
	School / university name: <form:input path="schoolName"/>
	<form:errors path="schoolName" />
	<br>
	City: <form:input path="city"/>
	<form:errors path="city" />
	<br>
	Grade: <form:input path="grade"/>
	<form:errors path="grade" />
	<br>
	Direction: <form:input path="direction"/>
	<form:errors path="direction" />
	<br>
	<input type="submit" value="submit">
	</form:form>
	
</body>
</html>