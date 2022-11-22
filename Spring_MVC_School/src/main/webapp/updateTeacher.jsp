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
<form:form action="updateteacherbyid" modelAttribute="teacher">
Teacher Name: <form:input path="Tname"/><br>
Teacher Class: <form:input path="Tclass"/><br>
Teacher Subject: <form:input path="Tsub"/><br>
Teacher Id: <form:hidden path="Tid"/><br>
<form:button>Submit</form:button>
</form:form>
</body>
</html>