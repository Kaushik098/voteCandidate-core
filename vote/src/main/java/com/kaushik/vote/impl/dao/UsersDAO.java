package com.kaushik.vote.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kaushik.vote.VoteCandidate;
import com.kaushik.vote.model.Candidate;
import com.kaushik.vote.model.Cast;
import com.kaushik.vote.model.Users;
import com.kaushik.vote.util.ConnectionUtil;

public class UsersDAO implements VoteCandidate {
   
//a.)User Registration
	
	 public void register(Users users){
		 
		    Connection conn = ConnectionUtil.getConnection();
		    
		    String registerUser = "Insert into users(adhaar_name, adhaar_number, dob, username, u_password, mobile_number, gender, entry)"
		                                +"values(?,?,?,?,?,?,?,?)";
		    
			try {
				PreparedStatement prepareUserRegister = conn.prepareStatement(registerUser);
				
				prepareUserRegister.setString(1, users.getAdhaarName() );
				prepareUserRegister.setString(2, users.getAdhaarNumber() );
				prepareUserRegister.setString(3, users.getDob() );
				prepareUserRegister.setString(4, users.getUsername() );
				prepareUserRegister.setString(5, users.getPassword() );
				prepareUserRegister.setString(6, users.getMobileNumber() );
				prepareUserRegister.setString(7, users.getGender() );
				prepareUserRegister.setInt(8, users.getEntry() );

				int resultUserRegister = prepareUserRegister.executeUpdate();
				
			    System.out.println(resultUserRegister+ " user added");
			} //try close
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   // catch close
			
			finally{
				 try
   	          {
   	              if(conn!=null)
   	                  conn.close();
   	          }
   	          catch(SQLException se){}
			}  // finally close
	 }
	 
//b.) User Login 
	 
	 public void login(Users userLogin){
		    
		 Connection conn = ConnectionUtil.getConnection();
	     String usernameCopy = "" , passwordCopy = "";

	     String checkUser = " SELECT username,u_password FROM users WHERE adhaar_number = ?"; 
		 try {
			PreparedStatement prepareCheck = conn.prepareStatement(checkUser);
			prepareCheck.setString(1, userLogin.getAdhaarNumber());
			ResultSet resultCheck = prepareCheck.executeQuery();
			
			    while(resultCheck.next()){
				    usernameCopy = String.valueOf(resultCheck.getString(1));
				    passwordCopy = String.valueOf(resultCheck.getString(2));
			    }
			   
			    if(usernameCopy.equals(userLogin.getUsername()) && passwordCopy.equals(userLogin.getPassword()))
				        System.out.println("Welcome to vote you favourite candidate");
			    else
				        System.out.println("Please check whether username and password is entered correctlt or not");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 finally{
			 try
	          {
	              if(conn!=null)
	                  conn.close();
	          }
	          catch(SQLException se){}
		  }  // finally close
	 } //end of login method 

public void newCandidate(Candidate addNew) {}

public void showCandidates() {}

public void addVote(Cast cast) {}

public int getVoteCount(Cast cast) {
	return 0;
 }
}
