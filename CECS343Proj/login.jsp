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
<style>/* Set a style for all buttons */

</style>
<body>
<%
%>
<form action = "Login" method = "get"> 
<div align = "center">
	<div style="color:red">${errorMessage}</div>	
    <div class="imgcontainer">
      <img src="avatar.png" alt="Avatar" class="avatar">
    </div>
	
    <div class="container">
      <label for="username"><b>UserName :</b></label>
      <input type="text" placeholder="Enter Username" name="username" required>
    </div>
      <td> </td>
     <div></div>
      <label for="password"><b>Password :</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>

    <div>
      <button type="submit"> Log In</button>
	</div>
</div>
</form>

</body>
</html>
