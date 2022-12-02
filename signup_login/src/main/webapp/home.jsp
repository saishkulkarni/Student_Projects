<%@page import="dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Login Successful</h1><br>
<%
Employee employee=(Employee)session.getAttribute("employee");
%>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Password</th>
</tr>
<tr>
<td><%=employee.getId() %></td>
<td><%=employee.getName()%></td>
<td><%=employee.getEmail() %></td>
<td><%=employee.getMobile() %></td>
<td><%=employee.getPassword() %></td>
</tr>
</table>

<a href="fetchall">Fetch All Details</a>


</body>
</html>