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
		<a href="Create"><button>Add more</button></a>
	<table style="width:100%" >
		<tr>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Details</th>
			<th>Action</th>
		</tr>
		<c:forEach items = "${experience}" var = "exp">
			<tr>
				<td align="center" valign="middle">
					<c:out value = "${exp.startDate}"/>
				</td>
				<td align="center" valign="middle">
					<c:out value = "${exp.endDate}"/>
				</td>
				<td align="center" valign="middle">
					<c:out value = "${exp.companyName}"/><br>
					<c:out value = "${exp.city}"/><br>
					<c:out value = "${exp.jobTitle}"/><br>
					<br>
					<c:out value = "${exp.taskDescription}"/>
				</td>
				<td align="center" valign="middle">
					<a href="Edit/${exp.id}"><button>Edit</button></a>
					<a href="Delete/${exp.id}"><button>Delete</button></a>
				</td>
			</tr>
		</c:forEach>
		</table> 
	</c:otherwise>
</c:choose>

</body>
</html>