<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Product> list=(List<Product>)session.getAttribute("list");%>

<%char c='a'; %>

<form action="order">
<table border="">
<tr>
<th>Name</th>
<th>Price</th>
<th>Select</th>
</tr>
<% for(Product product:list){%>
<tr>
<td><%=product.getName()%></td>
<td><%=product.getCost()%></td>
<td><input type="checkbox" value="<%=product.getId()%>" name=<%=c++%>></td>
</tr>
<%}%>
</table>
<button>Order</button>
</form>
</body>
</html>