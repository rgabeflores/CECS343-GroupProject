package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class Login {
	
	public Login() {
		

	}
	
	/*
	 * Determine if the login information for the user is correct
	 */
	public String[] ensureLoginSuccess(String user, String password) {
		Connection conn = getConnection();
		try {
			PreparedStatement ptsmt = (PreparedStatement) conn.prepareStatement("SELECT * from user where userName = ? AND password = ?");
			ptsmt.setString(1, user);
			ptsmt.setString(2, password);
			
			ResultSet rs = ptsmt.executeQuery();
			//if the result set is empty, that means there is no user with that password
			if(rs.next()== false) {
				String[] mp = new String[2];
				mp[0] = null;
				mp[1] = null;
				return mp;
			}
			
			//else, the result set contains the username and password
			else {
				String[] mp = new String[2];
				mp[0] = rs.getString("userName");
				mp[1] = rs.getString("password");
				return mp;
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
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