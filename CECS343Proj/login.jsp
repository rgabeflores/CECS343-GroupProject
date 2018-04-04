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
	Login log = new Login();
	String action = request.getParameter("action");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	
	if(action!=null && action.equals("login")){
		String[] loginInfo = log.ensureLoginSuccess(username, password);
		if(loginInfo!=null & loginInfo[0] !=null && loginInfo[1] !=null){
			out.print("SUCCESS");
			response.sendRedirect("hello.jsp");
		}
		else{
			out.print("Incorrect login information, type in username and password again");
			
		}
	}

	else{
		out.print("Enter username and password to login");
	}

%>

<form action = "login.jsp">
	<table class = "table">
		<tr>
			<p> Username <input name = "username" class = "form-control"></p>
			<p> Password <input name = "password" class = "form-control"></p>
			<p> <button class = "btn-sn" name = "action" value="login"></button>
		</tr>
	


</body>
</html>
