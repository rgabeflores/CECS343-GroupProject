package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ApplicationsDAO {
	private ArrayList<Application> applicationList;
	
	public static void main(String[] args) {
		ApplicationsDAO dao = new ApplicationsDAO();
		Connection connection = dao.getConnection();
		System.out.println(connection);
		dao.closeConnection(connection);
	}
	
	public ApplicationsDAO(){
		Map<String, Integer> appMap = new HashMap<String, Integer>();
		ArrayList<Application> applicationList = new ArrayList<Application>();
		appMap.put("Tic-Tac-Toe", 4);
		appMap.put("Clue", 27);
		int count=0;
		for(Map.Entry<String, Integer> entry : appMap.entrySet()) {
			Application a1 = new Application(count, (entry.getKey()));
			applicationList.add(a1);
			
//			Connection conn = getConnection();
//			
//			try {
//				
//				PreparedStatement ptsmt = (PreparedStatement) conn.prepareStatement("INSERT INTO application(applicationNo, applicationName) VALUES(?,?)");
//				ptsmt.setInt(1, count);
//				ptsmt.setString(2, entry.getKey());
//				
//				ptsmt.execute();
//						
//						
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//			
//			
//			count++;
		}
	
	}
	
	//This method adds an application to the application list
	public void addApplication(String x, String y) {
		

		Connection c = getConnection();
		try {
			int sd = Integer.parseInt(x);
			PreparedStatement prepState = (PreparedStatement) c.prepareStatement("INSERT INTO application(applicationNo, applicationName) VALUES(?,?)");
			prepState.setInt(1,sd);
			prepState.setString(2, y);
			prepState.execute();
			System.out.println("wtf");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	public void deleteApplication(String x) {
		Connection c = getConnection();
		try {
			int strToInt = Integer.parseInt(x);
			PreparedStatement ptsmt = (PreparedStatement)c.prepareStatement("DELETE from application where applicationNo = ?");
			ptsmt.setInt(1,strToInt );
			ptsmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Retrieves all the applications from the database by placing them in a list and returning the list
	public ArrayList<Application> retrieveAll(){
		ArrayList<Application> applications = new ArrayList<Application>();
		Connection conn = getConnection();
		
		try {
			PreparedStatement prepState = (PreparedStatement) conn.prepareStatement("SELECT * from application");
			ResultSet rs = prepState.executeQuery();
			while(rs.next()){
				Application newApp = new Application(rs.getInt("applicationNo"), rs.getString("applicationName"));
				applications.add(newApp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return applications;
		
		
	}
	
	public ArrayList<Integer> performStatsSummary(String listOfValues) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		StringBuilder strbuild = new StringBuilder();
		try {
			for(int i=0;i<listOfValues.length();i++) {
				//if the character detected is an integer, then proceed to add to stringbuilder
				if(Character.isDigit(listOfValues.charAt(i))) {
					strbuild.append(listOfValues.charAt(i));
				}
				//else if,  if the character is detected as a space or comma, then...
				else if(listOfValues.charAt(i) == ' ' || listOfValues.charAt(i) == ',') {
					//if the stringbuilder is not empty, then place the values
					if(strbuild != null) {
						try {
							int placement = Integer.parseInt(strbuild.toString());
							values.add(placement);
							strbuild = new StringBuilder();
						}
						catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
				//else, if a character that is not a digit or a comma/space, then that means this is unacceptable
				else{
					return null;
				}
			}
			//if the string builder is still not empty after traversing the list then add the remainder to the arraylist
			if(strbuild!=null) {
				try {
					int placement = Integer.parseInt(strbuild.toString());
					values.add(placement);
					strbuild = new StringBuilder();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		return values;
	}
	
	//This method computes the average value of the elements inside a list
	public double getMean(ArrayList<Integer>vals) {
		int sum=0;
		for(int i=0; i<vals.size();i++) {
			sum += vals.get(i);
		}
		try {
			return (double)(sum/vals.size());
		}catch(ArithmeticException e) {
			e.printStackTrace();
			return 0;
		}
	}
	//This method computes the median of the elements inside a list
	public double getMedian(ArrayList<Integer> vals) {
		Collections.sort(vals);
		try {
			if(vals.size()%2 != 0) {
				int middleIndex = vals.size()/2;
				return vals.get(middleIndex);
			}
			else {
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
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

	public void closeConnection(Connection conn) {
		try {
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

