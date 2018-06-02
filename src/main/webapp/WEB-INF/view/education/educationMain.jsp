<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple CV Creator - education management</title>

<!-- BootStrap4 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script> 

</head>
<body class="bg-dark text-white">

	<div id="header">
	    <jsp:include page="../fragments/header.jsp"/>
	</div>

	<div class="container-fluid">
	<h3>Education List:</h3>
	
	<table class="table table-dark table-hover">
		<tr>
			<th class="text-center">Full Name</th>
			<th class="text-center">City</th>
			<th class="text-center">Action</th>
		</tr>
		<c:forEach items = "${personItems}" var = "person">
			<tr>
				<td align="center" valign="middle">
					<c:out value = "${person.fullName}"/>
				</td>
				<td align="center" valign="middle">
					<c:out value = "${person.address.city}"/>
				</td>
				<td align="center" valign="middle">
					<a href="/Simple_CV_Creator/Education_Management/${person.id}/Details">
						<button class="btn btn-info">Education Details</button>
					</a>
					<a href="/Simple_CV_Creator/Person_Management/${person.id}/Details">
						<button class="btn btn-success">Person Details</button>
					</a>
				</td>
			</tr>
		</c:forEach>
		</table> 
		<br>

	</div>

</body>
</html>