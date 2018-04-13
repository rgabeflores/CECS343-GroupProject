package com.project;

import java.util.*;

public class BusinessInfo {
	private LinkedHashMap<String, String> hoursOfOperation;
	
	
	public BusinessInfo(){
		hoursOfOperation = new LinkedHashMap<String, String>();
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
	public void showBusinessHours() {
		StringBuilder hoursDisplay = new StringBuilder();
		for(Map.Entry<String, String> me : hoursOfOperation.entrySet()) {
			hoursDisplay.append(me.getKey() + " " + me.getValue() + " a ");
		}
		System.out.println(hoursDisplay.toString());
	}
	
	
	
	
}
