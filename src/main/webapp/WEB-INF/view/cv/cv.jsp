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
<body>

	<span>
		<a href="/Simple_CV_Creator/index"> <button>Return to main page</button> </a>
	</span>
	<span>
		<a href="/Simple_CV_Creator/Person_Management/${personDto.id}/CV/success"> <button>Generate PDF file</button> </a>
	</span>
	
	<h2>CV Preview</h2>
	
	<div>
	<h3>Personal information:</h3>
		First Name: <c:out value = "${personDto.firstName}"/><br>
		Last Name: <c:out value = "${personDto.lastName}"/><br>
		Birth Date: <c:out value = "${personDto.birthday}"/><br>
		Phone Number: <c:out value = "${personDto.phonenumber}"/><br>
		E-mail: <c:out value = "${personDto.email}"/><br>
	</div>
	
	<div>
	<h3>Address:</h3>
		Postal Code: <c:out value = "${personDto.address.postalCode}"/><br>
		City: <c:out value = "${personDto.address.city}"/><br>
		Street: <c:out value = "${personDto.address.street}"/><br>
		Address 1: <c:out value = "${personDto.address.buildingNumber}"/><br>
		Address 2: <c:out value = "${personDto.address.doorNumber}"/><br>
	</div>
	
	<div>
	<h3>Education:</h3>
		<table style="width:100%" >
			<tr>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Details</th>
				<th>City</th>
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
						<c:out value = "${edu.schoolName}"/><br>
						<c:out value = "${edu.grade}"/><br>
						<c:out value = "${edu.direction}"/><br>
						<br>
					</td>
					<td align="center" valign="middle">
						<c:out value = "${edu.city}"/>
					</td>
				</tr>
			</c:forEach>
		</table> 
	</div>	
	
	<div>
	<h3>Experience:</h3>
		<table style="width:100%" >
			<tr>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Details</th>
				<th>Task Description</th>
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
	
</body>
</html>