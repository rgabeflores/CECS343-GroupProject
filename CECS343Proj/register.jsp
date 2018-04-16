<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.project.UserDAO"  %>
<%@ page import="com.project.Register"  %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p> Create New Account </p>
	
	
<%

%>

<form action = "Register" method = "get">
	<div style="color:red">${errorMessage}</div>
	<table>
		<p> Username <input name = "username" type = "text"></p>
		<p> Password <input name = "password" type = "text"></p>
		<p> Email Address <input name = "emailAddress" type = "text"></p>
		<p> Press to make new account <input type = "submit" value = 'Submit'> </p>
	</table>
</form>

</body>
</html>
