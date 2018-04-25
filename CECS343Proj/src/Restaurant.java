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
	private BusinessInfo hoursOpen;
	
	
	//Default constructor
	public Restaurant() {
			
	}
	//Overloaded constructor with one parameter : restaurantName
	public Restaurant(String restName) {
		restaurantName = restName;
	}
	//Overloaded constructor with two parameters : restaurantName and restaurantID
	public Restaurant(String restName, int id) {
		restaurantName = restName;
		restaurantID = id;
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
	 * Setter for the restaurant's name
	 * @param name
	 */
	public BusinessInfo getRestaurantBusinessInfo() {
		return hoursOpen;
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
	
	public void setRestaurantBusinessInfo(BusinessInfo bi) {
		hoursOpen = bi;
	}
	
	public String toString() {
		return restaurantAddress + " " + restaurantType;
	}
	
	/**
	 * This method calculates the average rating of the restaurant based off user ratings
	 * @return average
	 */
	public double calculateAverageRating() {
		int summation=0;
		for(Review r : restaurantReviewList) {
			summation+=r.getStarsGiven();
		}
		double average = summation/restaurantReviewList.size();
		return average;
		
	}
}
	
	

