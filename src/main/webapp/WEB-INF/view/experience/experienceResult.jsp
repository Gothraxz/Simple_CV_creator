<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Experience information</title>

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
			<a href="/Simple_CV_Creator/Experience_Management/Main" class="btn btn-info">
				Return to experience management
			</a>
		</span>
		<br>
		<br>
	</div>

	<div class="container">
		<h1>Experience Details:</h1>

		<c:choose>
			<c:when test="${empty experience}">
				<p>Experience not found, please add new position:</p>
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
				<c:forEach items = "${experience}" var = "exp">
					<tr>
						<td align="center" valign="middle">
							<c:out value = "${exp.startDate}"/>
						</td>
						<td align="center" valign="middle">
							<c:out value = "${exp.endDate}"/>
						</td>
						<td align="center" valign="middle">
							<b>Company name: </b><c:out value = "${exp.companyName}"/><br>
							<b>City: </b><c:out value = "${exp.city}"/><br>
							<b>Job title: </b><c:out value = "${exp.jobTitle}"/><br>
							<br>
							<b>Main tasks: </b>
							<br>
							<c:out value = "${exp.taskDescription}"/>
						</td>
						<td align="center" valign="middle">
							<a href="Edit/${exp.id}">
								<button class="btn btn-info">Edit</button>
							</a>
							<a href="Delete/${exp.id}">
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