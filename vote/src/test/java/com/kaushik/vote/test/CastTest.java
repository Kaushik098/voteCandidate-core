package com.kaushik.vote.test;

import java.time.LocalDate;

import com.kaushik.vote.impl.dao.CastDAO;
import com.kaushik.vote.model.Cast;

public class CastTest {

	public static void main(String args[]){
	     
		
		Cast cast = new Cast();

// a.) User voting
		
   	  /*  LocalDate todayDate = LocalDate.now();
   	    
		cast.setUserID(3);
		cast.setCandidateID(1808);
        cast.setVotedDate(todayDate.toString());
		
        CastDAO vote = new CastDAO();
        vote.addVote(cast);   */ 
        
 
// b.)View VoteCounts (Individual Candidate)
     
	     cast.setCandidateID(1806);
	     
	     CastDAO count = new CastDAO();
	     int total = count.getVoteCount(cast);
        
	     System.out.println("The total vote count for candidateId "+cast.getCandidateID()+ " is : "+total);   
	     
		  
	     
	     
	      
	     
	}
}
