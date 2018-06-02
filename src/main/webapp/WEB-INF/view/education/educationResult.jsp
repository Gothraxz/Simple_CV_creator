<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Education information</title>

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
		<h1>Education Details:</h1>
		
		<c:choose>
			<c:when test="${empty education}">
				<p>Education not found, please add new position:</p>
				<a href="Create">
					<button class="btn btn-outline-primary float-left">Create</button>
				</a>
			</c:when>
			<c:otherwise>
				<a href="Create">
					<button class="btn btn-outline-primary">Add more</button>
				</a>
				<br>
				<br>
			<table class="table table-dark table-hover">
				<tr>
					<th class="text-center">Start Date</th>
					<th class="text-center">End Date</th>
					<th class="text-center">Details</th>
					<th class="text-center">Action</th>
				</tr>
				<c:forEach items = "${education}" var = "edu">
					<tr>
						<td align="center" valign="middle">
							<c:out value = "${edu.startDate}"/>
						</td>
						<td align="center" valign="middle">
							<c:out value = "${edu.endDate}"/>
						</td>
						<td align="center" valign="middle">
							<b>School / University: </b><c:out value = "${edu.schoolName}"/><br>
							<b>City: </b><c:out value = "${edu.city}"/><br>
							<br>
							<b>Direction: </b><c:out value = "${edu.direction}"/><br>
							<b>Grade: </b><c:out value = "${edu.grade}"/>
						</td>
						<td align="center" valign="middle">
							<a href="Edit/${edu.id}">
								<button class="btn btn-info">Edit</button>
							</a>
							<a href="Delete/${edu.id}">
								<button class="btn btn-danger">Delete</button>
							</a>
						</td>
					</tr>
				</c:forEach>
				</table> 
			</c:otherwise>
		</c:choose>
</div>
</body>
</html>