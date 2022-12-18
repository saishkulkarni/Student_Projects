<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student</title>
</head>
<body>
<h1>Student Details</h1><br>
<table border="1">
<tr>
<th>Id</th><th>Name</th><th>Mobile</th><th>English</th><th>Mathematics</th><th>Science</th><th>Total Marks</th><th>Percentage</th><th>Edit</th><th>Delete</th>
</tr>
<c:forEach var="student" items="${students}">
<tr>
<th>${student.getId()}</th><th>${student.getName()}</th><th>${student.getMob()}</th><th>${student.getEnglish()}</th><th>${student.getMaths()}</th><th>${student.getScience()}</th><th>${student.getTotalmarks()}</th><th>${student.getPercentage()}</th><th><a href="editStudent"><button>Edit</button></a></th><th><a href="deleteStudent?id=${student.getId()}"><button>Delete</button></a></th>
</tr>
</c:forEach>
</table>
</body>
</html>