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

public class CandidateDAO implements VoteCandidate{

	//a.) Lists All Candidates
	
	    public void showCandidates(){
	    	   
	    	   Connection conn = ConnectionUtil.getConnection();
	    	   Candidate value = new Candidate();
	    	   String candidateList = "Select * from candidate";
	    	   
	    	   try {
				PreparedStatement prepareCandidateList = conn.prepareStatement(candidateList);
				ResultSet result = prepareCandidateList.executeQuery();
				
				   while(result.next())
				   {  
					    value.setCandidateId(result.getInt(1));
					    value.setCandidateName(result.getString(2));					    
					    System.out.println(value.toString());
				   }
			   }  //try close
	    	   catch (SQLException e) {
				   e.printStackTrace();
			   }   //catch close
	    	   
	    	   finally{
	    	          try
	    	          {
	    	              if(conn!=null)
	    	                  conn.close();
	    	          }
	    	          catch(SQLException se){}
	    	      }   //finally close
	    		   
	    } // end of show candidate method

	//b.) Adding new Candidate 
	    
		public void newCandidate(Candidate addNew) {
			   Connection conn = ConnectionUtil.getConnection();
			   
			   String candidate = "Insert into candidate (candidate_id, candidate_name) VALUES (?,?)";
			   try {
				PreparedStatement prepareCandidate = conn.prepareStatement(candidate);
				prepareCandidate.setInt(1, addNew.getCandidateId());
				prepareCandidate.setString(2, addNew.getCandidateName());
				int resultCandidate = prepareCandidate.executeUpdate();
				
				System.out.println(resultCandidate+" row Added");
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
	    	      }   //finally close
			   
		}

	public void register(Users user) {}

	public void login(Users user) {}

	public void addVote(Cast cast) {}

	public int getVoteCount(Cast cast) {
		return 0;
	}
	    	  	   
}
	
