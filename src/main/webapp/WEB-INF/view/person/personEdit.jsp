<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal information - edit</title>

<!-- BootStrap4 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script> 

</head>
<body class="bg-dark text-white">

	<div class="container">
		<br>
		<span>
			<a href="/Simple_CV_Creator/index" class="btn btn-warning">
				Return to main page
			</a>
		</span>
		<br>
		<br>
	</div>
	<div class="container">
		<h1>Please edit personal details:</h1>
		
		<form:form method="POST" modelAttribute="person">
			<div class="form-group">
				<label>First Name:</label>
				<form:input path="firstName" class="form-control"/>
				<form:errors path="firstName" class="badge badge-danger"/>
			</div>
			<div class="form-group">
				<label>Last Name:</label> 
				<form:input path="lastName" class="form-control"/>
				<form:errors path="lastName" class="badge badge-danger"/>
			</div>
			<div class="form-group">
				<label>Date of Birth:</label>
				<form:input path="birthday" class="form-control"/>
				<form:errors path="birthday" class="badge badge-danger"/>			
			</div>
			<div class="form-group">
				<label>Phone Number:</label>
				<form:input path="phonenumber" class="form-control"/>
				<form:errors path="phonenumber" class="badge badge-danger"/>		
			</div>
			<div class="form-group">
				<label>E-mail:</label>
				<form:input path="email" class="form-control"/>
				<form:errors path="email" class="badge badge-danger"/>
			</div>
		<input class="btn btn-primary float-right" type="submit" value="submit">
		</form:form>
	</div>

</body>
</html>