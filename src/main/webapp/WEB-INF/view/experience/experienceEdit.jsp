<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Experience information - edit</title>
</head>
<body>

	<span>
		<a href="/Simple_CV_Creator/index"> <button>Return to main page</button> </a>
	</span>

	<h1>Please edit experience details:</h1>
	
	<form:form method="POST" modelAttribute="experience">
	<%-- Person: <form:select path="person" items="${personItems}" multiple="false" 
	itemValue="id" itemLabel="fullName"/>
	<form:errors path="fullName" /> --%>
	Start Date: <form:input path="startDate"/>
	<form:errors path="startDate" />
	<br>
	End Date: <form:input path="endDate"/>
	<form:errors path="endDate" />
	<br>
	Company Name: <form:input path="companyName"/>
	<form:errors path="companyName" />
	<br>
	City: <form:input path="city"/>
	<form:errors path="city" />
	<br>
	Job Title: <form:input path="jobTitle"/>
	<form:errors path="jobTitle" />
	<br>
	Task Description: <form:input path="taskDescription"/>
	<form:errors path="taskDescription" />
	<br>
	<input type="submit" value="submit">
	</form:form>
	
</body>
</html>