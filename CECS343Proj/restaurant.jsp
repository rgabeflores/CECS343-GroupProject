<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.Restaurant"  %>
<%@ page import="com.project.RestaurantDAO"  %>
<%@ page import="com.project.BusinessInfo"  %>
<%@ page import="com.project.Review"  %>
<%@ page import="java.util.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
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

	<form action = "Search" method = "get">
    	<button type = "submit">Search</button>	
 		<input name = "keyword" type="search" placeholder="Search..">
 	</form>
	<p>
	<%
	
	RestaurantDAO rd = new RestaurantDAO();
	
	Restaurant selectedRestaurant = (Restaurant) request.getAttribute("chosenRestaurant");
	ArrayList<Review> reviews = rd.retrieveReviews(selectedRestaurant.getRestaurantID());
	
	out.println(selectedRestaurant.getRestaurantBusinessInfo().showBusinessHours() + " " + selectedRestaurant.getRestaurantName());
	%>
	</p>
	
	<div class ="col" align = "left">
		<table>
		<% for(Review r:reviews){
				int stars = r.getStarsGiven();
				int i=0;
				int [] stats = r.countLikesAndDislikes();
		%>
			<tr>
				<td>
			<%
				while(i<stars){
			%>
					<span class="fa fa-star checked"></span>
			<%
					i++;
				}
				while(i<5){
					i++;
			%>
					<span class="fa fa-star"></span>
			<%
				}
	
			%>	</td>
			</tr>
			
			<tr>
				<td><%=r.getReviewNumber() %></td>
				<td> <%=r.getComment() %></td>
				<td> <%=stats[0]%></td>
				<td> <%=stats[1] %></td>
			</tr>
	<% 	
	    }
	%>
	</table>
	</div>
	
	
	<div class ="col" align = "right">
		<%
		BusinessInfo bi = selectedRestaurant.getRestaurantBusinessInfo();
		for(Map.Entry<String, String> mp : bi.getHours().entrySet()){
		%>
			<tr>
				<td><%=mp.getKey() %> </td>
				<td><%=mp.getValue() %> </td>
			</tr>
		<%	
		}		
		%>
	
	</div>
	
</body>
</html>
