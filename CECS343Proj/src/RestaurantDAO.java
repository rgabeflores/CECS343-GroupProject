package com.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import com.mysql.jdbc.PreparedStatement;


public class RestaurantDAO {
	
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
	
}
