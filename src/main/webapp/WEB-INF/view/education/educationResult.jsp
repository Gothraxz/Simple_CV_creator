<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Education information</title>
</head>
<body>

	<span>
		<a href="/Simple_CV_Creator/index"> <button>Return to main page</button> </a>
	</span>

<h1>Education Details:</h1>
<!-- TODO person name  -->

<c:choose>
	<c:when test="${empty education}">
		<p>Education not found, please add new position:</p>
		<a href="Create"><button>Create</button></a>
	</c:when>
	<c:otherwise>
		<a href="Create"><button>Add more</button></a>
	<table style="width:100%" >
		<tr>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Details</th>
			<th>Action</th>
		</tr>
		<c:forEach items = "${education}" var = "edu">
			<tr>
				<td align="center" valign="middle">
					<c:out value = "${edu.startDate}"/>
				</td>
				<td align="center" valign="middle">
					<c:out value = "${edu.endDate}"/>
				</td>
				<td align="center" valign="middle">
					<c:out value = "${edu.schoolName}"/><br>
					<c:out value = "${edu.city}"/><br>
					<br>
					<c:out value = "${edu.direction}"/><br>
					<c:out value = "${edu.grade}"/>
				</td>
				<td align="center" valign="middle">
					<a href="Edit/${edu.id}"><button>Edit</button></a>
					<a href="Delete/${edu.id}"><button>Delete</button></a>
				</td>
			</tr>
		</c:forEach>
		</table> 
	</c:otherwise>
</c:choose>

</body>
</html>