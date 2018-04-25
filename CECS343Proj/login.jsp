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
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>Login</title>
</head>
<style>/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: black;
    padding: 14px 20px;
    margin: 10px 0;
    border: 2;
    cursor: pointer;
    width: 80%; }
       
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 70%;
    padding: 12px 25px;
    margin: 8px 0;
    display: inline-block;
    border: 4px solid #ccc;
    box-sizing: border-box; }

</style>
<body>
<%
%>
<form action = "Login" method = "get"> 
	
    <div class="imgcontainer">
      <img src="avatar.png" alt="Avatar" class="avatar">
    </div>
	<div style="color:red">${errorMessage}</div>	
    <div class="container">
      <label for="username"><b>UserName :</b></label>
      <input type="text" placeholder="Enter Username" name="username" required>
    </div>
      <td> </td>
     <div>
      <label for="password"><b>Password :   </b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
    </div>
    <div>
      <button type="submit"> Log In</button>
	</div>
</form>

</body>
</html>
