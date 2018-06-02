<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address information - clear</title>

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
			<a href="/Simple_CV_Creator/Address_Management/Main" class="btn btn-info">
				Return to address management
			</a>
		</span>
		<br>
		<br>
	</div>

	<div class="container">
		<h1>Delete address entry:</h1>
		
			<b>Postal Code: </b><c:out value = "${address.postalCode}"/><br>
			<b>City: </b><c:out value = "${address.city}"/><br>
			<b>Street: </b><c:out value = "${address.street}"/><br>
			<b>Address 1: </b><c:out value = "${address.buildingNumber}"/><br>
			<b>Address 2: </b><c:out value = "${address.doorNumber}"/><br>
			<br>
			
		<h5>Please confirm:</h5>
		<div class=" container row">
			<form:form method="POST" modelAttribute="address">
				<button type="submit" class="btn btn-danger"> Yes </button>
			</form:form>
		
			<a href="/Simple_CV_Creator/index">
				<button class="btn btn-warning"> No </button>
			</a>
		</div>
	</div>
</body>
</html>