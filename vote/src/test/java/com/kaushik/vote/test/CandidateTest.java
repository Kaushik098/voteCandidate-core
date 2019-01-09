package com.kaushik.vote.test;

import com.kaushik.vote.impl.dao.CandidateDAO;
import com.kaushik.vote.model.Candidate;

public class CandidateTest {

	public static void main(String args[]){
		 
	// to display the candidates
		
	/*	 CandidateDAO candidate = new CandidateDAO();
		 candidate.showCandidates();    */
		 
	// to add a new candidate
		 
		 Candidate add = new Candidate();
		 
		 add.setCandidateId(1808);
		 add.setCandidateName("Sachin Tendulkar");
		 
		 CandidateDAO addCandidate = new CandidateDAO();
		 addCandidate.newCandidate(add);
		 
		 
	}
}
