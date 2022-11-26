<%@page import="session_management.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<%
HttpSession httpSession=request.getSession();
User user=(User)httpSession.getAttribute("user");

String email=user.getEmail();
String password=user.getPassword();
%>
<h1>Welcome to Home</h1><br>
</body>
</html>