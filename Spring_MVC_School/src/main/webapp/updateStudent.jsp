<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body style="background:linen;">
<form:form action="updatestudentbyid" modelAttribute="student">
Student Name: <form:input path="Sname"/><br>
Student Class: <form:input path="Sclass"/><br>
Student Percentage: <form:input path="Sper"/><br>
Student Id: <form:hidden path="Sid"/><br>
<form:button>Submit</form:button>
</form:form>
</body>
</html>