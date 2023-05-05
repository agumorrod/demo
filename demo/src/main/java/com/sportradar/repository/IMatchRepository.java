package com.sportradar.repository;

import java.util.List;

import com.sportradar.dto.Match;

public interface IMatchRepository{
	List<Match> getAllMatches() throws Exception;
	Match getMatchById(Long idMatch) throws Exception;
	boolean updateMatch(Match match) throws Exception;
	boolean createMatch(Match match) throws Exception;
	List<Match> getAllMatchesOnCurse() throws Exception;
	List<Match> getAllMatchesFinished() throws Exception;
	Long getGoalsByMatch(Long idMatch) throws Exception;
}
