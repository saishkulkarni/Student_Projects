<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body style="background:linen;">
<form:form action="saveStudent" modelAttribute="student">
<h3 style="color:indigo;">Name: <form:input path="sname"/></h3><br>
<h3 style="color:indigo;">Student Class: <form:input path="sclass"/></h3><br>
<h3 style="color:indigo;">Student Percentage: <form:input path="sper"/></h3><br>
<form:button>Submit</form:button>
</form:form>
</body>
</html>