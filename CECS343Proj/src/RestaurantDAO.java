package com.project;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.mysql.jdbc.PreparedStatement;


public class RestaurantDAO extends HttpServlet{
	
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		RestaurantDAO rd = new RestaurantDAO();
		String input = scan.nextLine();
		ArrayList<Restaurant> list = rd.searchRestaurant(input);
		for(Restaurant r : list) {
			System.out.println(r.toString());
		}
	}
	
	public RestaurantDAO() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException{
		String restaurantName = ((ServletRequest) request).getParameter("keyword").toString();
		
		ArrayList listOfRestaurants = this.searchRestaurant(restaurantName);
		
		
		response.setContentType("text/html");
		System.out.println(listOfRestaurants);
		
		request.setAttribute("restaurantResults", listOfRestaurants);
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("searchresults.jsp");
		reqDispatcher.forward(request, response);
	}
	
	
	/**
	 * This method is called once a button pertaining to a restaurant is clicked, and the user will
	 * be redirected to the restaurant's page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= ((ServletRequest)request).getParameter("restaurantID").toString();
		int restID = Integer.parseInt(id);
		String restName = ((ServletRequest)request).getParameter("restaurantName").toString();
		String restAddress = ((ServletRequest)request).getParameter("restaurantAddress").toString();
		String restType = ((ServletRequest)request).getParameter("restaurantType").toString();
		
		Restaurant aRestaurant = new Restaurant();
		aRestaurant.setRestaurantID(restID);
		aRestaurant.setRestaurantName(restName);
		aRestaurant.setRestaurantType(restType);
		
		request.setAttribute("chosenRestaurant", aRestaurant);
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("restaurant.jsp");
		reqDispatcher.forward(request, response);
		
	}
	
	
	//This method searches the designated restaurant name in the database and gives back results of that particular restaurant name
	public ArrayList<Restaurant> searchRestaurant(String restaurantName) {
		ArrayList<Restaurant> searchResults = new ArrayList<Restaurant>();
		Connection c= getConnection();
		try {
			PreparedStatement statement = (PreparedStatement) c.prepareStatement("SELECT * from restaurant where restaurantName=?");
			statement.setString(1,restaurantName );
			ResultSet rs = statement.executeQuery();
			//if the result set is empty, this indicates the lack of search results
			if(rs==null) {
				return null;
			}
			//else result set contains search results 
			else {
				while(rs.next()) {
					Restaurant r = new Restaurant();
					int restID = rs.getInt("restaurantID");
					String restAddr = rs.getString("restaurantAddress");
					String restType = rs.getString("restaurantType");
					String restName = rs.getString("restaurantName");
					r.setRestaurantID(restID);
					r.setRestaurantName(restName);
					r.setRestaurantAddress(restAddr);
					r.setRestaurantType(restType);
					searchResults.add(r);
					
				}
			}
			return searchResults;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method retrieves the restaurant's additional business information including hours of operation,etc
	 * @return
	 */
	public BusinessInfo retrieveRestaurantInfo(int restaurantID) {
		Connection conn = getConnection();
		try {
			PreparedStatement ptsmt = (PreparedStatement) conn.prepareStatement("SELECT * from restaurant_hours where restaurantID = ?");
			ptsmt.setInt(1, restaurantID);
			ResultSet rs = ptsmt.executeQuery();
			
			ArrayList<String> dailyHours = new ArrayList<String>();
			
			while(rs.next()) {
				String sundayHours = rs.getString("Sunday");
				String mondayHours = rs.getString("Monday");
				String tuesdayHours = rs.getString("Tuesday");
				String wednesdayHours = rs.getString("Wednesday");
				String thursdayHours = rs.getString("Thursday");
				String fridayHours = rs.getString("Friday");
				String saturdayHours = rs.getString("Saturday");
				
				dailyHours.add(sundayHours);
				dailyHours.add(mondayHours);
				dailyHours.add(tuesdayHours);
				dailyHours.add(wednesdayHours);
				dailyHours.add(thursdayHours);
				dailyHours.add(fridayHours);
				dailyHours.add(saturdayHours);
				
				BusinessInfo busInfo = new BusinessInfo();
				busInfo.addBusinessInfo(dailyHours);
				busInfo.showBusinessHours();
				
				return busInfo;	
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Review<> retrieveReviewHistory(){
		
	}
	
	
	
	public Connection getConnection() {
		String connectionUrl = "jdbc:mysql://localhost/muneerfirsttable";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
		}
		catch(InstantiationException e ) {
			e.printStackTrace();
		}
		catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
