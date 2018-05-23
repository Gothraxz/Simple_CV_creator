<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address information - create</title>
</head>
<body>

	<span>
		<a href="/Simple_CV_Creator/index"> <button>Return to main page</button> </a>
	</span>

	<h1>Please add address details:</h1>
	
	<form:form method="POST" modelAttribute="address">
	<%-- Person: <form:select path="person" items="${personItems}" multiple="false" 
	itemValue="id" itemLabel="fullName"/>
	<form:errors path="fullName" /> --%>
	Postal code: <form:input path="postalCode"/>
	<form:errors path="postalCode" />
	<br>
	City: <form:input path="city"/>
	<form:errors path="city" />
	<br>
	Street Name: <form:input path="street"/>
	<form:errors path="street" />
	<br>
	Address 1: <form:input path="buildingNumber"/>
	<form:errors path="buildingNumber" />
	<br>
	Address 2: <form:input path="doorNumber"/>
	<form:errors path="doorNumber" />
	<br>
	<input type="submit" value="submit">
	</form:form>
	
</body>
</html>