package com.sportradar.service;

import java.util.List;

import com.sportradar.entities.Goal;
import com.sportradar.entities.Match;

public interface IMatchService {
	// Empieza un partido
	void runMatch();
	// Se marca un gol
	Goal scoreGoal();
	// fin de la primera mitad
	// Empieza la segunda mitad
	
	List<Match> unfinishedMatch();
	
	// Se acaba el partido
	List<Match> finishedMatch();
}
