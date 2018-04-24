package com.project;

import java.util.*;

public class BusinessInfo {
	private LinkedHashMap<String, String> hoursOfOperation;
	
	
	public BusinessInfo(){
		hoursOfOperation = new LinkedHashMap<String, String>();
	}
	
	public LinkedHashMap<String, String> getHours(){
		return hoursOfOperation;
	}
	
	/**
	 * This method adds the hours of operation for a particular restaurant
	 * @param businessHours
	 */
	public void addBusinessInfo(ArrayList<String> businessHours) {
		String [] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		for(int i=0; i<7;i++) {
			hoursOfOperation.put(daysOfWeek[i], businessHours.get(i));
		}
	}
	
	/**
	 * This method displays the business hours of operation for the restaurant
	 */
	public String showBusinessHours() {
		StringBuilder hoursDisplay = new StringBuilder();
		for(Map.Entry<String, String> me : hoursOfOperation.entrySet()) {
			hoursDisplay.append(me.getKey() + " " + me.getValue() + " a ");
		}
		return hoursDisplay.toString();
	}

	
	
	
}
