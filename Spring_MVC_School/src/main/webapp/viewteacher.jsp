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
<th>Teacher Id</th>
<th>Teacher Name</th>
<th>Teacher Class</th>
<th>Teacher Subject</th>
<th>Delete</th>
<th>Update</th>
</tr>

<tr>
<td>${teacher.getTid()}</td>
<td>${teacher.getTname()}</td>
<td>${teacher.getTclass()}</td>
<td>${teacher.getTsub()}</td>
<td><a href="deleteTeacher?Id=${teacher.getTid()}">Delete</a>
<td><a href="updateTeacher?Id=${teacher.getTid()}">Update</a>
</tr>

</table>
</body>
</html>