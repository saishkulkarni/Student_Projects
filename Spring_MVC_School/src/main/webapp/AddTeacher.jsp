<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
</head>
<body style="background:linen;">
<form:form action="saveTeacher" modelAttribute="teacher">
<h3 style="color:indigo;">Name: <form:input path="tname"/></h3><br>
<h3 style="color:indigo;">Teacher Class: <form:input path="tclass"/></h3><br>
<h3 style="color:indigo;">Teacher Subject: <form:input path="tsub"/></h3><br>
<form:button>Submit</form:button>
</form:form>
</body>
</html>