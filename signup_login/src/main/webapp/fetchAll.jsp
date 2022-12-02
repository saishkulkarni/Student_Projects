<%@page import="dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FetchAll</title>
</head>
<body>
<%List<Employee> list=(List<Employee>)request.getAttribute("list") ;%>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Password</th>
</tr>
<%for(Employee employee:list){ %>
<tr>
<td><%=employee.getId() %></td>
<td><%=employee.getName()%></td>
<td><%=employee.getEmail() %></td>
<td><%=employee.getMobile() %></td>
<td><%=employee.getPassword() %></td>
</tr>
<%} %>

</table>

<a href="logout">Logout</a>
</body>
</html>