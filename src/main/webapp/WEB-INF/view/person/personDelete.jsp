<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal information - clear</title>
</head>
<body>

	<h1>Delete person:</h1>
	
		First Name: <c:out value = "${person.firstName}"/><br>
		Last Name: <c:out value = "${person.lastName}"/><br>
		Birth Date: <c:out value = "${person.birthday}"/><br>
		Phone Number: <c:out value = "${person.phonenumber}"/><br>
		E-mail: <c:out value = "${person.email}"/><br>
		<br>
		
	Please confirm:
	<form:form method="POST" modelAttribute="person">
	<button type="submit">Yes</button>
	</form:form>

	<a href="/Simple_CV_Creator/index"> <button>No</button> </a>

</body>
</html>