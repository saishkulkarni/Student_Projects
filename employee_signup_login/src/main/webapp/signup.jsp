<%@page import="employee.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="x" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<x:form action="signup" modelAttribute="employee">
Name : <input type="text" name="name"><br>
Email: <input type="text" name="email"><br>
Password: <input type="password" name="password"><br>
Gender:<input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female">Female
<button>Login</button>
<button type="reset">Reset</button>
</x:form>
</body>
</html>