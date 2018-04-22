<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.project.Login"  %>
<%@ page import="com.project.Register"  %>
<%@ page import="com.project.Restaurant"  %>
<%@ page import="com.project.Review"  %>
<%@ page import="com.project.User"  %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title> Welcome ^.^</title>
</head>
<style>
</style>
<body>

<div class="w3-bar w3-teal">
  <a href="register.jsp" class="w3-bar-item w3-button">Home</a>
  <a href="#" class="w3-bar-item w3-button">Link 1</a>
  <a href="#" class="w3-bar-item w3-button">Link 2</a>
  <a href="#" class="w3-bar-item w3-button">Link 3</a>
</div>
    
<div class="topnav" align = "center">
 <form action = "Search" method = "get">
    <button type = "submit">Search</button>	
 	<input name = "keywords" type="search" placeholder="Search..">
 </form>
 
  <a href="login.jsp">
    <button>Login</button>
  </a>
  <a href="register.jsp">
    <button>Register</button>
</div>

</body>
</html>
