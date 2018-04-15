package com.project;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.mysql.jdbc.PreparedStatement;


public class Login extends HttpServlet{
	/**
	 * Default constructor for the Login servlet object
	 */
	public Login() {
		super();

	}
	
	/**
	 * This method processes entered login information, and determines login validation
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException{
		String username = ((ServletRequest) request).getParameter("username").toString();
		String password = ((ServletRequest) request).getParameter("password").toString();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//checking and validating login credentials
		String[] loginInfo = this.ensureLoginSuccess(username, password);
		//redirect to home page, if login is successful
		if(loginInfo!=null & loginInfo[0] !=null && loginInfo[1] !=null){
			response.sendRedirect("hello.jsp");
		}
		//else, redirect back to login page and notify end user of invalid username/password combination
		else{
			request.setAttribute("errorMessage","Invalid Username/password");
			RequestDispatcher disp  = request.getRequestDispatcher("/login.jsp");
			disp.forward(request, response);
		}
	}		
	
	protected void doPost(HttpServlet request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
