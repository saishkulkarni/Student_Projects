<%@page import="java.util.ArrayList"%>
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
<%  int a=9; %>
<%! int a=5; %>

<% System.out.println(a); %>
<% response.getWriter().print(a); %><br>
<% out.print(a); %><br>
<%--Hello Java --%>
<%=this.a %><br>
<%
List<Integer> list=new ArrayList();
list.add(1);
list.add(2);
list.add(3);
%>
<%=list %><br>
<%
for(int x:list)
{
out.println(x);	
}
%><br>

<%for(int x:list){ %>
	<%=x%><br>
<%}%>
<%=a %>

</body>
</html>