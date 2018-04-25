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

<link rel="stylesheet" href="css/style.css" type="text/css" />

<title>Insert title here</title>
</head>
<body>
	<p> Create New Account </p>
	
	
<%

%>

<form action = "Register" method = "GET">
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
      <label for="emailAddress"><b>Email Address :   </b></label>
      <input type="emailAddress" placeholder="Enter Email Address" name="emailAddress" required>
     </div>
    <div>
      <button type="submit"> Register</button>
	</div>
	
</form>

</body>
</html>
