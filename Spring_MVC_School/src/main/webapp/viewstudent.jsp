<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
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

<tr>
<td>${student.getSid()}</td>
<td>${student.getSname()}</td>
<td>${student.getSclass()}</td>
<td>${student.getSper()}</td>
<td><a href="deleteStudent?Id=${student.getSid()}">Delete</a>
<td><a href="updateStudent?Id=${student.getSid()}">Update</a>
</tr>

</table>
</body>
</html>