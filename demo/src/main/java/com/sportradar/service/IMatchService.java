package com.sportradar.service;

import java.util.List;

import com.sportradar.dto.Match;

public interface IMatchService {
	List<Match> getAllMatchesOnCurse() throws Exception;
	List<Match> getAllMatchesFinished() throws Exception;
	boolean createMatch(Match newMatch) throws Exception;
	void finishMatch(Long idMatch) throws Exception;
	Match getMatch(Long idMatch) throws Exception;
	boolean updateMatch(Match match) throws Exception;
	Long getGoalsByMatch(Long idMatch) throws Exception;
}
