package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;

public class Review {
	
	private int reviewNumber;
	private int starsGiven; //the rating number between 1-5 given by the author of the review
	private String comment; //the actual content of the review
	private HashMap<String, Boolean> likesDislikes; //keeps track of who liked and disliked the review
	
	
	//Overloaded constructor for a review object, used when retrieving reviews of restaurants from database
	public Review(int restaurID, int reviewNum) {
		likesDislikes = new HashMap<String, Boolean>();
		try {
			Connection c = getConnection();
			PreparedStatement statement = (PreparedStatement) c.prepareStatement("select * from review_stats inner join review on review_stats.restaurantID = review.restaurantID AND review_stats.reviewNumber = review.reviewNumber"
					+ "															where review_stats.restaurantID = ? AND review_stats.reviewNumber = ?");
			statement.setInt(1,restaurID);
			statement.setInt(2,revNum);
			ResultSet rs = statement.executeQuery();
			//retrieves review stats such as likes and dislikes
			while(rs.next()) {
				String firstEntry = rs.getString("thumbedBy");
				boolean secondEntry = rs.getBoolean("likeOrDislike");
				likesDislikes.put(firstEntry,secondEntry );
				reviewNumber = revNum;
				starsGiven = rs.getInt("starRating");
				comment = rs.getString("reviewContent");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
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
			statement.executeUpdate();
			
			
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
			statement.setString(2,this.reviewNumber);
			statement.setString(3, u.getUsername());
			
			//remove the user from the likesDislikes hashmap
			likesDislikes.remove(userName);
			
			ResultSet rs = statement.executeQuery();
			//if the result set is empty, this implies user has never left a like or dislike for a review, so return false
			if(rs.next()==false) {
				return false;
			}
			//else, the user or disliked it, so delete the user's decision from the database
			else {
				PreparedStatement statement2 = (PreparedStatement) c.prepareStatement("delete from review_stats where restaurantID = ? AND reviewNumber = ? AND thumbedBy = ?");
				statement2.setInt(1,r.getRestaurantID());
				statement2.setInt(2,this.reviewNumber);
				statement2.setString(3, u.getUsername());
				statement2.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	/**
	 * This method counts the number of likes and dislikes a review has received
	 * @return
	 */
	public int[] countLikesAndDislikes() {
		int likesCount=0;
		int dislikesCount=0;
		for(Map.Entry<String, Boolean> entry : likesDislikes.entrySet()) {
			if(entry.getValue()==true) {
				likesCount++;
			}
			else {
				dislikesCount++;
			}
		}
		int[] stats = new int[2];
		stats[0] = likesCount;
		stats[1] = dislikesCount;
		return stats;
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
