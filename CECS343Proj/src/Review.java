package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;

public class Review {
	
	private int reviewNumber;
	private int starsGiven;
	private String comment;
	private HashMap<String, Boolean> likesDislikes;
	
	
	//Default constructor for a review object
	public Review() {
		likesDislikes = new HashMap<String, Boolean>();
		try {
			Connection c = getConnection();
			PreparedStatement statement = (PreparedStatement) c.prepareStatement("select thumbedBy, likeOrDislike from review_stats where restaurantID = ? AND reviewNumber = ?");
			statement.setInt(1,2);
			statement.setInt(2,  3);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String firstEntry = rs.getString("thumbedBy");
				boolean secondEntry = rs.getBoolean("likeOrDislike");
				likesDislikes.put(firstEntry,secondEntry );
			}
			
		}
		catch(Exception e) {
			
		}
		
	}
	
	public int getReviewNumber() {
		return reviewNumber;
	}
	
	public String getComment() {
		return comment;
	}
	
	public int getStarsGiven() {
		return starsGiven;
	}
	
	
	//This method updates a review's amount of likes or dislikes by adding a like or dislike to the review
	public boolean updateLikeOrDislike(User u, boolean decision, Restaurant r) {
		
		//if the rating list contains a user that has previously rated a certain review
		//then deny permission to add a rating once again
		if(likesDislikes.containsKey(u)) {
			return false;
		}
		//else add a like or dislike to the review based on the user's decision
		likesDislikes.put(u.getUsername(), decision);
		
		try {
			Connection c = getConnection();
			PreparedStatement statement  = (PreparedStatement) c.prepareStatement("insert into review_stats(restaurantID, reviewNumber,thumbedBy, likeOrDislike) VALUES(?,?,?,?)");
			statement.setInt(1, r.getRestaurantID());
			statement.setInt(2, this.getReviewNumber());
			statement.setString(3, u.getUsername());
			statement.setBoolean(4,decision);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	//This method removes the user's decision of either liking or disliking a review
	public boolean removeLikeOrDislike(User u, Restaurant r) {
		try {
			Connection c = getConnection();
			PreparedStatement statement = (PreparedStatement) c.prepareStatement("SELECT * from review_stats where restaurantID = ? AND reviewNumber = ? AND thumbedBy = ?");
		    statement.setInt(1, r.getRestaurantID());
			statement.setString(2,);
			statement.setString(3, u.getUsername());
			
			ResultSet rs = statement.executeQuery();
			//if the result set is empty, this implies user has never left a like or dislike for a review, so return false
			if(rs.next()==false) {
				return false;
			}
			//else, the user or disliked it, so delete the user's decision from the database
			else {
				PreparedStatement statement2 = (PreparedStatement) c.prepareStatement("delete from review_stats where restaurantID = ? AND reviewNumber = ? AND thumbedBy = ?");
				statement2.setInt(1,r.getRestaurantID());
				statement2.setInt(2,2 );
				statement2.setString(3, u.getUsername());
				statement2.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
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
