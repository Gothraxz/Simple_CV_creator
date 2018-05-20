<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal information - create</title>
</head>
<body>

	<span>
		<a href="/Simple_CV_Creator/index"> <button>Return to main page</button> </a>
	</span>

	<h1>Please add personal details:</h1>
	
	<form:form method="POST" modelAttribute="person">
	First Name: <form:input path="firstName"/>
	<form:errors path="firstName" />
	<br>
	Last Name: <form:input path="lastName"/>
	<form:errors path="lastName" />
	<br>
	Date of Birth: <form:input path="birthday"/>
	<form:errors path="birthday" />
	<br>
	Phone Number: <form:input path="phonenumber"/>
	<form:errors path="phonenumber" />
	<br>
	E-mail: <form:input path="email"/>
	<form:errors path="email" />
	<br>
	<input type="submit" value="submit">
	</form:form>
	
</body>
</html>