package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Register {
	/*
	 * Default constructor for a Register object
	 */
	public Register() {
		
	}
	
	/*
	 * This method validates a user's username by checking if the username is already taken or not
	 * returns true if username is not taken, and returns false if username is taken (present in database)
	 */
	public boolean validateUserName(String username) {
		Connection c = getConnection();
		try {
					
			PreparedStatement ptsmt = (PreparedStatement) c.prepareStatement("SELECT from user where userName = ?");
			ptsmt.setString(1,username);
			ResultSet result = ptsmt.executeQuery();
			
	
			if(result.isBeforeFirst()) {
				System.out.println("SMH SMH");
				return false;
			}
			else {
				System.out.println("SMH2 SMH2");
				return true;
			}
			
			
		}
		//Catches if the SQL query fails (result of the query is null or 0) e.g. the username is not in the database
		catch(SQLException e) {
			System.out.println("SMH3 SMH3");
			e.printStackTrace();
			return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("SMH4 SMH4");
		return false;
	
	}
	
	
	
	/*
	 * This method validates if the format of the entered email address actually matches the criteria
	 * @return
	 */
	public boolean validateEmailAddress(String emailAddress) {
		boolean domainActive = false; //this flag determines whether the domain part of the email address has been reached
		boolean atSign = false;
		StringBuilder localPart = new StringBuilder();
		StringBuilder domain = new StringBuilder();
		
		try {
			//this loop will gather the content of the local part of 
			for(int j=0;j<emailAddress.length();j++) {
				//if the character in the address is an @
				if(emailAddress.charAt(j) == '@') {
					atSign=true;
					//if the domain flag is false, then we move on to the domain part, so build a stringbuilder to append to domain string
					if(!domainActive) {
						//if the local part is empty, then it is invalid
						if(localPart.length()==0) {
							return false;
						}
						//else, the local part is valid for now, so move on to domain...
						System.out.println(emailAddress.charAt(j) + localPart.toString());
						domainActive = true;
					}
					//else, there is an error since we cannot have any '@' in the domain
					else {
						return false;
					}
				}
				//else if the current character is a letter or digit, then validate if the localpart or domain is being analyzed...
				else if(Character.isLetterOrDigit(emailAddress.charAt(j)) || emailAddress.charAt(j)== '-') {
					//if the domain isn't touched yet, then append to the local segment of the email address
					if(!domainActive) {
						localPart.append(emailAddress.charAt(j));
					}
					else {
						domain.append(emailAddress.charAt(j));
					}
				}
				else if(emailAddress.charAt(j) == '.') {
					//if the '.' is the first character for the local part, then it is immediately invalid
					if(!domainActive && localPart.length()==0) {
						return false;
					}
					if(!domainActive) {
						localPart.append(emailAddress.charAt(j));
					}
					//if the current character is ".", and the previous character was also ".", then return false;
					else if(emailAddress.charAt(j-1)=='.'){
						return false;
					}
					else {
						domain.append(emailAddress.charAt(j));
					}
					
				}
			}
			//if the email address domain is empty or there isn't an at sign, then it is invalid
			if(domain.length()==0 || !atSign) {
				return false;
			}
			//if the first two digits of the domain are either or both hyphens, then it is also invalid, 
			else if(domain.charAt(0)== '-' || domain.charAt(domain.length()-1) =='-'){
				return false;
			}
			return true;
		}
		catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		return false;
	
	}
	
//	public boolean validateEmailAddress2() {
//		
//	}
	
	
	/*
	 *This method determines whether a user's password is strong (at least 1 character should be uppercase
	 * returns true if the strength is strong, and returns false if the password strength is weak
	 */
	public boolean validatePasswordStrength(String password) {
		try {
			int uppercaseCt = 0;
			
			//if the password length is less than 6 characters
			if(password.length()<6) {
				return false;
			}
			
			for(int i=0;i<password.length();i++) {
				char currentChar = password.charAt(i);
				//if the character is a letter and it is uppercase
				if( Character.isLetter(currentChar) && Character.isUpperCase(currentChar)) {
					uppercaseCt++;
				}
			}
			//if the amount of uppercase letters is lower than 1, then it is a weak password
			if(uppercaseCt<1) {
				return false;
			}
			return true;
			
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return false;
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

