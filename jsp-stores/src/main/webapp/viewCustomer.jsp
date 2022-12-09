<%@page import="dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
<%List<User> list=(List<User>)session.getAttribute("customerList"); %>
<h1>Customers</h1><br>
<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th> 
</tr>
<%for(User u:list){ %>
<tr>
<th><%=u.getId() %></th>
<th><%=u.getName()%></th>
<th><%=u.getEmail()%></th>
<th><%=u.getMobile()%></th>
</tr>
<%}%>
</table>
<br>
<a href="adminhomepage.html"><button>Back</button></a>
</body>
</html>