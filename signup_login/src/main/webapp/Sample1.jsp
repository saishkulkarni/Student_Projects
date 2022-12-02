<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC</title>
</head>
<body>
<%int a=3; %>
<%int b=4; %>
<%int c=5; %>
<h1>1</h1>
<h1>2</h1>
<%=a%><br>
<%out.print(b); %><br>
<%response.getWriter().print(c); %>
</body>
</html>