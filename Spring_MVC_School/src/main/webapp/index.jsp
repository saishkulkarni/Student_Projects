<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body style="background:linen;">

${msg}
<div style="background:darkorange;">
<h1 style="color:indigo;">Manage Student </h1>
<a href="loadStudent" style="color:lemonchiffon;"><button style="color:blue;">Add Student</button></a><br><br>
<a href="searchbyid.jsp"><button style="color:blue;">View Student By Id</button></a><br><br>
<a href="fetchall"><button style="color:blue;">View All Student</button></a><br>
</div>

<div style="background:hotpink;">
<h1 style="color:maroon;">Manage Teacher</h1>
<a href="loadTeacher"><button style="color:blue;">Add Teacher</button></a><br><br>
<a href="searchbyidt.jsp"><button style="color:blue;">View Teacher By Id</button></a><br><br>
<a href="fetchallt"><button style="color:blue;">View All Teacher</button></a><br>
</div>

</body>
</html>