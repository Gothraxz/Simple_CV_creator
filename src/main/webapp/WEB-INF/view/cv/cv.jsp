<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple CV Creator - CV</title>

<!-- BootStrap4 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script> 

</head>
<body class="bg-dark text-white">

	<div class="container">
		<span>
			<a href="/Simple_CV_Creator/index">
				<button class="btn btn-outline-primary">Return to main page</button>
			</a>
		</span>
		<span>
			<a href="/Simple_CV_Creator/Person_Management/${personDto.id}/CV/success">
				<button class="btn btn-outline-success">Generate PDF file</button>
			</a>
		</span>
	</div>
	<div class="container">
		<br>
		<h1>CV Preview:</h1>
		<br>
		<div class="container">
			<h3>Personal information:</h3>
			<b>First Name: </b><c:out value = "${personDto.firstName}"/><br>
			<b>Last Name: </b><c:out value = "${personDto.lastName}"/><br>
			<b>Birth Date: </b><c:out value = "${personDto.birthday}"/><br>
			<b>Phone Number: </b><c:out value = "${personDto.phonenumber}"/><br>
			<b>E-mail: </b><c:out value = "${personDto.email}"/><br>
			<br>
		</div>
		
		<div class="container">
			<h3>Address:</h3>
			<b>Postal Code: </b><c:out value = "${personDto.address.postalCode}"/><br>
			<b>City: </b><c:out value = "${personDto.address.city}"/><br>
			<b>Street: </b><c:out value = "${personDto.address.street}"/><br>
			<b>Address 1: </b><c:out value = "${personDto.address.buildingNumber}"/><br>
			<b>Address 2: </b><c:out value = "${personDto.address.doorNumber}"/><br>
			<br>
		</div>
		
		<div class="container-fluid">
		<h3>Education:</h3>
			<table class="table table-dark table-hover">
				<tr>
					<th class="text-center">Start Date</th>
					<th class="text-center">End Date</th>
					<th class="text-center">City</th>					
					<th class="text-center">Details</th>
				</tr>
				<c:forEach items = "${personDto.education}" var = "edu">
					<tr>
						<td align="center" valign="middle">
							<c:out value = "${edu.startDate}"/>
						</td>
						<td align="center" valign="middle">
							<c:out value = "${edu.endDate}"/>
						</td>
						<td align="center" valign="middle">
							<c:out value = "${edu.city}"/>
						</td>
						<td align="center" valign="middle">
							<c:out value = "${edu.schoolName}"/><br>
							<c:out value = "${edu.grade}"/><br>
							<c:out value = "${edu.direction}"/><br>
							<br>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br>
		</div>	
		
		<div class="container-fluid">
		<h3>Experience:</h3>
			<table class="table table-dark table-hover">
				<tr>
					<th class="text-center">Start Date</th>
					<th class="text-center">End Date</th>
					<th class="text-center">Details</th>
					<th class="text-center">Task Description</th>
				</tr>
				<c:forEach items = "${personDto.experiences}" var = "exp">
					<tr>
						<td align="center" valign="middle">
							<c:out value = "${exp.startDate}"/>
						</td>
						<td align="center" valign="middle">
							<c:out value = "${exp.endDate}"/>
						</td>
						<td align="center" valign="middle">
							<c:out value = "${exp.companyName}"/><br>
							<c:out value = "${exp.city}"/><br>
							<c:out value = "${exp.jobTitle}"/><br>
							<br>
						</td>
						<td align="center" valign="middle">
							<c:out value = "${exp.taskDescription}"/>
						</td>
					</tr>
				</c:forEach>
			</table> 
		</div>
	</div>
</body>
</html>