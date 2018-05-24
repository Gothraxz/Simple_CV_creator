<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple CV Creator - address management</title>
</head>
<body>

	<div id="header">
	    <jsp:include page="../fragments/header.jsp"/>
	</div>

	<div>
	<h3>Address List:</h3>
	
	<table style="width:100%" >
		<tr>
			<th>Full Name</th>
			<th>City</th>
			<th>Street</th>
			<th>Action</th>
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
					<c:out value = "${person.address.street}"/>
				</td>
				<td align="center" valign="middle">
					<a href="/Simple_CV_Creator/Address_Management/${person.id}/Details"><button>Address Details</button></a>
					<a href="/Simple_CV_Creator/Person_Management/${person.id}/Details"><button>Person Details</button></a>
				</td>
			</tr>
		</c:forEach>
		</table> 
		<br>

	</div>

</body>
</html>