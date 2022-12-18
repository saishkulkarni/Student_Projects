<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="x" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<h1>Enter Details Below</h1>
<x:form action="saveStudent" modelAttribute="student">
Name:<x:input path="name"/><br>
Mobile:<x:input path="mob"/><br>
<h1>Enter Marks Scored</h1><br>
Mathematics:<x:input path="maths"/><br>
English:<x:input path="english"/><br>
Science:<x:input path="science"/><br>
<x:button>Add</x:button><button type="reset">Reset</button>
</x:form>
<a href="index.jsp">Click here to Go Back</a>
</body>
</html>