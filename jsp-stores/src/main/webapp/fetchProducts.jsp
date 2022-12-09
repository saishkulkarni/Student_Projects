 <%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
<%List<Product> list=(List<Product>)session.getAttribute("productlist"); %>
<h1>Products</h1><br>
<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Price</th>
<th>Category</th> 
<th>Edit</th>
<th>Delete</th>
</tr>
<%for(Product p:list){ %>
<tr>
<th><%=p.getId() %></th>
<th><%=p.getName()%></th>
<th><%=p.getPrice()%></th>
<th><%=p.getCategory()%></th>
<th><a href="updateProduct.jsp?id=<%=p.getId()%>"><button>Edit</button></a></th>
<th><a href="deleteProduct?id=<%=p.getId()%>"><button>Delete</button></a></th>
</tr>
<%}%>
</table>
<br>
<a href="adminhomepage.html"><button>Back</button></a>
</body>
</html>