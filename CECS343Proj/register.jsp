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
	Register r = new Register();
	
	String action = request.getParameter("action");
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String emailAddress = request.getParameter("emailAddr");
	
	
%>

<%
	boolean passSuccess=r.validatePasswordStrength(password);
	boolean userSuccess=r.validateUserName(username);
	boolean emailSuccess = r.validateEmailAddress(emailAddress);
	//if the button was pressed then success
	if(action != null && action.equals("createAccount")){
		out.print("GOOD for now");
		if(userSuccess){
			if(passSuccess){
				if(emailSuccess){
					out.print("Account has been successfully made");
					UserDAO ud = new UserDAO();
					ud.insertNewUser(username, password, emailAddress);
				}
				else{
					out.print("Email address is already taken");
				}
			}
			else{
				out.print("Password is weak, enter a stronger password");
			}
		}
		
	}

%>	
	<form action = "register.jsp">
	<table>
		<p> Username <input name = "username" class = "form-control"></p>
		<p> Password <input name = "password" class = "form-control"></p>
		<p> Email Address <input name = "emailAddr" class = "form-control"></p>
		<p> Press to make new account <button class = "btn-sm" name = "action" value = "createAccount"></button>
	</table>
	
	
	


</body>
</html>