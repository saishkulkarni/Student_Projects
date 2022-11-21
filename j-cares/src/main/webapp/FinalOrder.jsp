<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
</head>
<body>
	<%
	List<Product> list2 = (List<Product>) session.getAttribute("list2");
	%>
	<%
	int a = 1;
	%>
	<%
	double sum = 0;
	%>
	<h2>Your Order is :</h2>
	<br>
	<table>
		<%
		for (Product product : list2) {
		%>
		<tr>
			<th><%=a++%>.</th>
			<th><%=product.getName()%></th>
			<th><%=product.getCost()%></th>
			<%
			sum = sum + product.getCost();
			%>
		</tr>
		<%
		}
		%>
	</table>
	<h2>
		Total Amount is :
		<%=sum%></h2>
</body>
</html>