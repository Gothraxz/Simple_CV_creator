<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal information</title>
</head>
<body>

		First Name: <c:out value = "${personDetails.firstName}"/><br>
		Last Name: <c:out value = "${personDetails.lastName}"/><br>
		Birth Date: <c:out value = "${personDetails.birthday}"/><br>
		Phone Number: <c:out value = "${personDetails.phonenumber}"/><br>
		E-mail: <c:out value = "${personDetails.email}"/><br>
		<br>
		<br>
		<a href="Edit">Edit</a>   <a href="Clear">Delete</a>

</body>
</html>