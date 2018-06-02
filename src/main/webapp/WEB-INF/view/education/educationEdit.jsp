<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Education information - edit</title>

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
			<a href="/Simple_CV_Creator/index" class="btn btn-success">
				Return to main page
			</a>
		</span>
		<span>
			<a href="/Simple_CV_Creator/Education_Management/Main" class="btn btn-info">
				Return to education management
			</a>
		</span>
		<br>
		<br>
	</div>

	<div class="container">
		<h1>Please edit education details:</h1>
		
		<form:form method="POST" modelAttribute="education">
		<div class="form-group">
			<label>Start Date:</label>
			<form:input path="startDate" class="form-control"/>
			<form:errors path="startDate" class="badge badge-danger"/>
		</div>
		<div class="form-group">
			<label>End Date:</label>
			<form:input path="endDate" class="form-control"/>
			<form:errors path="endDate" class="badge badge-danger"/>
		</div>
		<div class="form-group">
			<label>School / university name:</label>
			<form:input path="schoolName" class="form-control"/>
			<form:errors path="schoolName" class="badge badge-danger"/>
		</div>
		<div class="form-group">
			<label>City:</label>
			<form:input path="city" class="form-control"/>
			<form:errors path="city" class="badge badge-danger"/>
		</div>
		<div class="form-group">
			<label>Grade:</label>
			<form:input path="grade" class="form-control"/>
			<form:errors path="grade" class="badge badge-danger"/>
		</div>
		<div class="form-group">
			<label>Direction:</label>
			<form:input path="direction" class="form-control"/>
			<form:errors path="direction" class="badge badge-danger"/>
		</div>
		<input class="btn btn-primary float-right" type="submit" value="submit">
		</form:form>
	</div>
</body>
</html>