package com.project;
//
public class Application {
	private String appType;
	private int number;
	
	public Application(int n, String aT) {
		appType = aT;
		number = n;
	}
	
	public String getAppType() {
		return appType;
	}
	
	public int getAppNumber() {
		return number;
	}
	
	public String toString() {
		return appType + " " + number;
		
	}
	
}
