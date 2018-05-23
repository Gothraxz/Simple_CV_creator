<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>
</head>
<body>

	<span>
		<p>Personal information</p>
		
		<%-- <c:if test="${null personDetails}"> --%>
			<a href="Person_Management/Create"><button>Create</button></a>
		<%-- </c:if> --%>
<%-- 		<c:if test="${not null personDetails}">
			<a href="Edit"><button>Edit</button></a>
		</c:if> --%>
	</span>
	
	<span>
		<p>Address</p>
		
		<a href="Address_Management/Main"><button>Address Management</button></a>
	</span>
	
	<span>
		<p>Experience</p>
	</span>

</body>
</html>