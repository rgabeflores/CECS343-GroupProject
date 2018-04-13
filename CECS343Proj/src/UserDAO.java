package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class UserDAO {
	public UserDAO() {
		
		
	}
	
	/**
	 * This method retrieves an existing user from the database upon the successful matching of the username, password, and email address
	 * @param user
	 * @param pass
	 * @param emailAddr
	 * @return
	 */
	public User retrieveUser(String user, String pass, String emailAddr) {
		Connection c = getConnection();
		try {
			User u = new User();
			PreparedStatement daPrepState  = (PreparedStatement) c.prepareStatement("SELECT userName, password, emailAddress from user where userName = ? AND password = ? AND emailAddress = ?");
			daPrepState.setString(1, user);
			daPrepState.setString(2, pass);
			daPrepState.setString(3, emailAddr);
			ResultSet rs = daPrepState.executeQuery();
			while(rs.next()) {
				String userEntry = rs.getString(1);
				String passwordEnt = rs.getString(2);		
				u.setUserValues(userEntry, passwordEnt, emailAddr);
				return u;
			}
		}
		catch(Exception exce) {
			exce.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * This method inserts a newly registered user to the user table in the database
	 */
	public void insertNewUser(String username, String password, String emailAddress) {
		Connection c = getConnection();
		try {
			PreparedStatement ptsmt = (PreparedStatement)c.prepareStatement("INSERT INTO user(userName, password, emailAddress) VALUES (?, ?, ?)");
			ptsmt.setString(1, username );
			ptsmt.setString(2,password );
			ptsmt.setString(3, emailAddress);
			ptsmt.execute();
			
		}catch(Exception ex) {
			ex.printStackTrace();
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
