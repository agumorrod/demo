package com.sportradar.service;

import com.sportradar.entities.Match;

public interface IMatchService {
	
	void startMatch(Long idMatch);
	
	void finishMatch(Long idMatch);
	
	Match getMatch(Long idMatch);
	
	Match updateMatch(Match match); 
}
