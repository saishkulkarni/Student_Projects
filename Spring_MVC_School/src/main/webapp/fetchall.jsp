<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body style="background:linen;">
<table border="1" style=background:azure;>
<tr>
<th>Student Id</th>
<th>Student Name</th>
<th>Student Class</th>
<th>Student Percentage</th>
<th>Delete</th>
<th>Update</th>
</tr>

<c:forEach var="student" items="${students}">

<tr>
<td>${student.getSid()}</td>
<td>${student.getSname()}</td>
<td>${student.getSclass()}</td>
<td>${student.getSper()}</td>
<td><a href="deleteStudent?Id=${student.getSid()}">Delete</a>
<td><a href="updateStudent?Id=${student.getSid()}">Update</a>
</tr>

</c:forEach>
</table>
</body>
</html>