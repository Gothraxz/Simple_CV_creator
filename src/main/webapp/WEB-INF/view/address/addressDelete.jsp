<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address information - clear</title>
</head>
<body>

	<h1>Delete address:</h1>
	
<!-- TODO person name  -->
		Postal Code: <c:out value = "${address.postalCode}"/><br>
		City: <c:out value = "${address.city}"/><br>
		Street: <c:out value = "${address.street}"/><br>
		Address 1: <c:out value = "${address.buildingNumber}"/><br>
		Address 2: <c:out value = "${address.doorNumber}"/><br>
		<br>
		
	Please confirm:
	<form:form method="POST" modelAttribute="address">
	<button type="submit">Yes</button>
	</form:form>

	<a href="/Simple_CV_Creator/index"> <button>No</button> </a>

</body>
</html>