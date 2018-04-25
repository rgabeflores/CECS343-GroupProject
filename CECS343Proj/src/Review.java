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
	public Review(int restaurID, int revNum) {
		likesDislikes = new HashMap<String, Boolean>();
		try {
			Connection c = getConnection();
			PreparedStatement statement = (PreparedStatement) c.prepareStatement("select * from review_stats inner join review on review_stats.restaurantID = review.restaurantID AND review_stats.reviewNumber = review.reviewNumber"
					+ "															where review_stats.restaurantID = ? AND review_stats.reviewNumber = ?");
			statement.setInt(1,restaurID);
			statement.setInt(2,revNum);
			ResultSet rs = statement.executeQuery();
			reviewNumber = revNum;
			while(rs.next()) {
				String firstEntry = rs.getString("thumbedBy");
				boolean secondEntry = rs.getBoolean("likeOrDislike");
			
				likesDislikes.put(firstEntry, secondEntry );
				
				starsGiven = rs.getInt("starRating");
				comment = rs.getString("reviewContent");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void setReviewNumber(int num) {
		reviewNumber = num;
	}
	
	public void setStarsGiven(int stars) {
		starsGiven = stars;
	}
	
	public void setReviewContent(String content) {
		comment = content;
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
	public boolean updateLikeOrDislike(String name, boolean decision, int restaurantID) {
		
		//if the rating list contains a user that has previously liked or disliked a certain review
		//then..
		if(likesDislikes.containsKey(name)){
			//if the recent decision to either like or dislike matches the user's previous decision, then deny permission
			if(likesDislikes.get(name)==decision) {
				return false;
			}
			else {
				boolean active;
				//if the user has a previous like, then change it to a dislike
				if(likesDislikes.get(name)==true) {
					active = false;
					likesDislikes.put(name, false);
				}
				//if the user has a previous dislike, then change it to a like
				else {
					active = true;
					likesDislikes.put(name, true);
				}
				try {
					Connection c = getConnection();
					PreparedStatement ptsmt = (PreparedStatement) c.prepareStatement("UPDATE review_stats set likeOrDislike = ? where thumbedBy = ? AND restaurantID = ? AND reviewNumber = ?");
					ptsmt.setBoolean(1, active);
					ptsmt.setString(2, name);
					ptsmt.setInt(3,  restaurantID);
					ptsmt.setInt(4, this.reviewNumber);
					ptsmt.executeUpdate();
				}
				catch(Exception e) {
					e.printStackTrace();
				}	
			}
		}
		else {
			//else add a like or dislike to the review based on the user's decision
			likesDislikes.put(name, decision);
			//and update the review stats (likes and dislikes) in the database
			try {
				Connection c = getConnection();
				System.out.println(restaurantID + "    " + this.getReviewNumber());
				PreparedStatement statement  = (PreparedStatement) c.prepareStatement("insert into review_stats(restaurantID, reviewNumber,thumbedBy, likeOrDislike) VALUES(?,?,?,?)");
				statement.setInt(1, restaurantID);
				statement.setInt(2, this.getReviewNumber());
				statement.setString(3, name);
				statement.setBoolean(4,decision);
				statement.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return true;
		}
		return false;
		
	}
	
	//This method removes the user's decision of either liking or disliking a review
	public boolean removeLikeOrDislike(String userName, Restaurant r) {
		try {
			Connection c = getConnection();
			PreparedStatement statement = (PreparedStatement) c.prepareStatement("SELECT * from review_stats where restaurantID = ? AND reviewNumber = ? AND thumbedBy = ?");
		    statement.setInt(1, r.getRestaurantID());
			statement.setInt(2,reviewNumber);
			statement.setString(3, userName);
			
			
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
				statement2.setString(3,userName);
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
	
	public String toString() {
		return comment + " wehee " + starsGiven + " fsdf " + reviewNumber;
	}
	
	
}
