<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Details</title>
</head>
<body style="background:linen;">
<table border="1" style=background:azure;>
<tr>
<th>Teacher Id</th>
<th>Teacher Name</th>
<th>Teacher Class</th>
<th>Teacher Subject</th>
<th>Delete</th>
<th>Update</th>
</tr>

<c:forEach var="teacher" items="${teachers}">

<tr>
<td>${teacher.getTid()}</td>
<td>${teacher.getTname()}</td>
<td>${teacher.getTclass()}</td>
<td>${teacher.getTsub()}</td>
<td><a href="deleteTeacher?Id=${teacher.getTid()}">Delete</a>
<td><a href="updateTeacher?Id=${teacher.getTid()}">Update</a>
</tr>

</c:forEach>
</table>
</body>
</html>