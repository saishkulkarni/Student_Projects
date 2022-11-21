<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>${msg}</h1>
<form action="login">
EMail: <input type="text" name="email"><br>
Password: <input type="password" name="password"><br>
<button>Submit</button>
<button type="reset">Reset</button>

</form>
</body>
</html>