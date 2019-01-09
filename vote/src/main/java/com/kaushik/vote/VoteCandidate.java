package com.kaushik.vote;

import com.kaushik.vote.model.Candidate;
import com.kaushik.vote.model.Cast;
import com.kaushik.vote.model.Users;

public interface VoteCandidate {
      
	// CandidateDAO
	   public void newCandidate(Candidate addNew);
	   public void showCandidates();
	   
	//UsersDAO
	   public void register(Users user);
	   public void login(Users user);
	   
	//CastDAO
	   public void addVote(Cast cast);
	   public int getVoteCount(Cast cast);
}

