<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.Restaurant"  %>
<%@ page import="com.project.RestaurantDAO"  %>
<%@ page import="java.util.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

	<form action = "Search" method = "get">
    	<button type = "submit">Search</button>	
 		<input name = "keyword" type="search" placeholder="Search..">
 	</form>

	<%
	ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>)request.getAttribute("restaurantResults");
	if(restaurantList ==null){
		out.println("No restaurants havve been identified with that name");
	}
		
	else{
	
	%>
	
		<%
			for(Restaurant r:restaurantList){ %>
			<tr>
			<td> <%= r.getRestaurantID() %> </td>
			<td> <%= r.getRestaurantName() %> </td>
			<td> <%= r.getRestaurantAddress() %> </td>
			
            <form action = "Search" method = "POST">
				<input type = "hidden" name = "restaurantID" value=<%=r.getRestaurantID() %> />
				<input type = "hidden" name = "restaurantName" value = <%= r.getRestaurantName() %> />
				<input type = "hidden" name = "restaurantAddress" value = <%= r.getRestaurantAddress() %> />
				<input type = "hidden" name = "restaurantType" value = <%= r.getRestaurantType() %> />
                <input type="submit" name="Click" value="Click" >
            </form>
      
			</tr>
	
			<%}
	}
	%>
	
</body>
</html>	
