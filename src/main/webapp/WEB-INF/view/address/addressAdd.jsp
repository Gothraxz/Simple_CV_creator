<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address information - create</title>

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
			<a href="/Simple_CV_Creator/Address_Management/Main" class="btn btn-info">
				Return to address management
			</a>
		</span>
		<br>
		<br>
	</div>

	<div class="container">
		<h1>Please add address details:</h1>
		
		<form:form method="POST" modelAttribute="address">
		<div class="form-group">
			<label>Postal code:</label>
			<form:input path="postalCode" class="form-control"/>
			<form:errors path="postalCode" class="badge badge-danger"/>
		</div>
		<div class="form-group">
			<label>City:</label>
			<form:input path="city" class="form-control"/>
			<form:errors path="city" class="badge badge-danger"/>
		</div>
		<div class="form-group">
			<label>Street Name:</label>
			<form:input path="street" class="form-control"/>
			<form:errors path="street" class="badge badge-danger"/>
		</div>
		<div class="form-group">
			<label>Address 1:</label>
			<form:input path="buildingNumber" class="form-control"/>
			<form:errors path="buildingNumber" class="badge badge-danger"/>
		</div>
		<div class="form-group">
			<label>Address 2:</label>
			<form:input path="doorNumber" class="form-control"/>
			<form:errors path="doorNumber" class="badge badge-danger"/>
		</div>
		<input class="btn btn-primary float-right" type="submit" value="submit">
		</form:form>
	</div>
</body>
</html>