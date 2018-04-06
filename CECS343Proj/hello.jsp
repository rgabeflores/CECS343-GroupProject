<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.project.ApplicationsDAO"  %>
<%@ page import="com.project.Application"  %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.Connection" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>

 
Hello World!
	
	<h1> Applications </h1>
	
	<a href="register.jsp">Create User</a>
	
<%
	ApplicationsDAO app = new ApplicationsDAO();
	
	String action = request.getParameter("action");
	String number = request.getParameter("number");
	String name = request.getParameter("name");
%>	

<%

	if(action != null && action.equals("create")){
		app.addApplication(number, name);

	 }
	
	else if(action != null && action.equals("delete")){
		app.deleteApplication(number);
	
	}
	 	

	List<Application> daList = app.retrieveAll();
%>	
	

<form action = "hello.jsp">
	<table class = "table">
	<tr>
		<td><input name ="number" class ="form-control"> </td>
		<td><input name = "name" class ="form-control"> </td>
		<td><button class = "btn-sm" name = "action" value ="create">
			Add
			</button>
		</td>
		<td> <button class = "btn2" name = "action" value = "delete">
			Delete
			</button>
		</td>
	</tr>
	
<%  for(Application somethingElse: daList){ 
%>		<tr>
			<td> <%= somethingElse.getAppNumber() %> </td>
			<td> <%= somethingElse.getAppType() %> </td>
		</tr>
<% 
	}
%>  </table>


	<p> Welcome to the Statistics Summary Calculator, enter a list of numbers to compute their stats </p>
	<table>
		<tr>
			<input name = "listOfValues" class = "form-control">
			<button class = "btn3" name = "action" value= "calcStats">
			Calculate	
			</button>
		</tr>
	
	
	</table>
	

<%
	String listOfValues = request.getParameter("listOfValues");
	ArrayList<Integer> demValues=app.performStatsSummary(listOfValues);
	out.print(demValues);
%>	
	<table>
		<tr>
			<p> Mean : <% double i = app.getMean(demValues);
						  out.print(i);
						%>
			</p>
			<p> Median : <% double y = app.getMedian(demValues);
						  out.print(y);
						%>
		
			</p>
			
			
		</tr>
	
	
	</table>
 
 <a href="hello.jsp">dfdf </a>
</body>
</html>


