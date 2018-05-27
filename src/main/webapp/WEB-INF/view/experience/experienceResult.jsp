<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address information</title>
</head>
<body>

	<span>
		<a href="/Simple_CV_Creator/index"> <button>Return to main page</button> </a>
	</span>

<h1>Experience Details:</h1>
<!-- TODO person name  -->

<c:choose>
	<c:when test="${empty experience}">
		<p>Experience not found, please add new position:</p>
		<a href="Create"><button>Create</button></a>
	</c:when>
	<c:otherwise>
		Postal Code: <c:out value = "${address.postalCode}"/><br>
		City: <c:out value = "${address.city}"/><br>
		Street: <c:out value = "${address.street}"/><br>
		Address 1: <c:out value = "${address.buildingNumber}"/><br>
		Address 2: <c:out value = "${address.doorNumber}"/><br>
		<br>
		<br>
		<a href="Edit"><button>Edit</button></a>
		<a href="Delete"><button>Delete</button></a>
	</c:otherwise>
</c:choose>

</body>
</html>