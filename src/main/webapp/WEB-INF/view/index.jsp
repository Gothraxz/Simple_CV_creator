<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple CV Creator - home</title>
</head>
<body>
	
	<div id="header">
	    <jsp:include page="fragments/header.jsp"/>
	</div>

	<div>
		<a href="Person_Management/Create"><button>Create new</button></a>
	</div>

	<div>
	<h3>Person List:</h3>
	
	<table style="width:100%" >
		<tr>
			<th>Full Name</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:forEach items = "${personItems}" var = "person">
			<tr>
				<td align="center" valign="middle">
					<c:out value = "${person.fullName}"/>
				</td>
				<td align="center" valign="middle">
					<c:out value = "${person.phonenumber}"/>
				</td>
				<td align="center" valign="middle">
					<c:out value = "${person.email}"/>
				</td>
				<td align="center" valign="middle">
					<a href="Person_Management/${person.id}/Details"><button>Details</button></a>
					<a href="Person_Management/${person.id}/CV"><button>View CV</button></a>
					<%-- <a href="Person_Management/${person.id}/Edit"><button>Edit</button></a>
					<a href="Person_Management/${person.id}/Delete"><button>Delete</button></a> --%>
				</td>
			</tr>
		</c:forEach>
		</table> 
		<br>

	</div>
	
</body>
</html>