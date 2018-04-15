<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.project.Login"  %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.Connection" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<%
%>

<form action = "Login" method = "get"> 
	<div style="color:red">${errorMessage}</div>
	<table class = "table">
	
		<tr>
			<p> Username <input name = "username" type ="text"></p>
			<p> Password <input name = "password" type = "text"></p>
			<p> <input type = "submit" value = 'Submit'> </p>
		</tr>
	</table>
</form>

</body>
</html>
