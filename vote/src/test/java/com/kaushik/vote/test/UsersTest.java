package com.kaushik.vote.test;

import java.sql.PreparedStatement;

import com.kaushik.vote.impl.dao.UsersDAO;
import com.kaushik.vote.model.Users;

public class UsersTest {

	 public static void main(String args[]){
		  	 
		 Users users = new Users();
		
// Registration
		 
		 users.setAdhaarName("Karthik");
		 users.setAdhaarNumber("212020101010");
		 users.setDob("07/04/2000");
		 users.setUsername("karthik");
		 users.setPassword("karthik");
		 users.setMobileNumber("9080908090");
		 users.setGender("male");
		 users.setEntry(0);
		 
		// System.out.println(users.toString());
		 
		 UsersDAO registerUser = new UsersDAO();
		 registerUser.register(users);     
		  
		 
//Login
		 
/*		 users.setUsername("bhuvana");
		 users.setPassword("bhuvi001");
		 users.setAdhaarNumber("202020101010");
		 
		 UsersDAO loginUser = new UsersDAO();
		 loginUser.login(users);   */
		 
	 }
}
