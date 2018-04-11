package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class Restaurant {
	private int restaurantID;
	private String restaurantName;
	private String restaurantAddress;
	private String restaurantType;
	private ArrayList<Review> restaurantReviewList;
//	private BusinessInfo hoursOfOperation;
	
	
	public Restaurant() {
		
	}
	
	/**
	 * Getter for the restaurant's ID
	 * @return
	 */
	public int getRestaurantID() {
		return restaurantID;
	}
	
	/**
	 * Getter for the restaurant's name
	 * @return
	 */
	public String getRestaurantName() {
		return restaurantName;
	}
	
	/**
	 * Setter for the restaurant's name
	 * @param name
	 */
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	
	/**
	 * Setter for the restaurant's name
	 * @param name
	 */
	public String getRestaurantType() {
		return restaurantType;
	}
	
	
	/**
	 * Setter for the restaurant's ID
	 * @param id
	 */
	public void setRestaurantID(int id) {
		restaurantID = id;
	}
	
	/**
	 * Setter for the restaurant's name
	 * @param name
	 */
	public void setRestaurantName(String name) {
		restaurantName = name;
	}
	
	/**
	 * Setter for the restaurant's name
	 * @param name
	 */
	public void setRestaurantAddress(String address) {
		restaurantAddress = address;
	}
	
	/**
	 * Setter for the restaurant's name
	 * @param name
	 */
	public void setRestaurantType(String type) {
		restaurantType = type;
	}
	
	public String toString() {
		return restaurantAddress + " " + restaurantType;
	}
	
	//This method 
	public double calculateAverageRating() {
		int summation=0;
		for(Review r : restaurantReviewList) {
			summation+=r.getStarsGiven();
		}
		double average = summation/restaurantReviewList.size();
		return average;
		
	}
	
	public double calcAverageRating() {
		Connection c = getConnection();
		try {	
			PreparedStatement statement = (PreparedStatement) c.prepareStatement("SELECT AVG(starsGiven) from restaurant INNER JOIN review on restaurant.restaurantID = review.restaurantID where restaurantID = ?");
			statement.setInt(1, this.restaurantID);
			ResultSet rs = statement.executeQuery();
			if(rs==null) {
				
			}
			else {
				while(rs.next()) {
					double avg = 
				}
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
//	
//	public void viewRestaurantHours() {
//		hoursOfOperation.viewBusinessHours();
//	}
	
	
}
