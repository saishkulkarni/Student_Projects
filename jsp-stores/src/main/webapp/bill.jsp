<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
</head>
<body>
<h1>Bill</h1><br>
<%List<Product> products=(List<Product>)session.getAttribute("products"); %>
<%double sum=0; %>
<table style="text-align: left">
<tr>
<th>Your Order is: </th>
<th></th>
</tr>
<% for(Product product:products){%>
<tr>
<th><%=product.getName() %></th>
<th><%=product.getPrice() %></th>
</tr>
<%sum=sum+product.getPrice(); %>
<%}%>
<tr>
<th>Your Total bill amount is: <%=sum%></th>
<th></th>
</tr>
</table>
<button onclick="window.print()">Print Bill</button>
<a href="customerhomepage.html"><button>Back</button></a>
</body>
</html>