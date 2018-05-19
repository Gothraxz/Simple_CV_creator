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
	<h3>Personal information:</h3>
		First Name: <c:out value = "${personDetails.firstName}"/><br>
		Last Name: <c:out value = "${personDetails.lastName}"/><br>
		Birth Date: <c:out value = "${personDetails.birthday}"/><br>
		Phone Number: <c:out value = "${personDetails.phonenumber}"/><br>
		E-mail: <c:out value = "${personDetails.email}"/><br>
	</div>
	
	<div>
	<h3>Address:</h3>
	</div>
	
	<div>
	<h3>Experience:</h3>
	</div>

</body>
</html>