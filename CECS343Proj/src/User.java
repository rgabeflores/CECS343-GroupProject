package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class User {
	private String username;
	private String password;
	private String emailAddress;
	private ArrayList<Integer> reviewList;
	
	public User() {
		System.out.println();
	}
	
	public User(String userN, String pass, String emailAddr) {
		username = userN;
		password = pass;
		emailAddress = emailAddr;
	}
	
	
	public void setUserValues(String userN, String pass, String emailAddr) {
		
	}
	
	/**
	 * Getter to retrieve username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Getter to retrieve password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Getter to retrieve email address
	 * @return
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

}
