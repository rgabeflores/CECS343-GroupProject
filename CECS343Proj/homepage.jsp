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
<title> Welcome ^.^</title>
</head>
<style>
/* Set a style for all buttons */
button {
    background-color: #0099ff;
    color: white;
    padding: 5px 10px;
    margin: auto;
    border: 2;
    cursor: pointer;
    width: 10%; }

input[type=search] {
    width: 50%;
    padding: 12px 25px;
    margin: 8px 0;
    display: inline-block;
    border: 4px solid #ccc;
    box-sizing: border-box; }
</style>
<body>

<div class="topnav" align = "center">
	<input type="search" placeholder="Search..">
  <a href="login.jsp">
    <button>Login</button>
  </a>
  <a href="register.jsp">
    <button>Register</button>
</div>


</body>
</html>
