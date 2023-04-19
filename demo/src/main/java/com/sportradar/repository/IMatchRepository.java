package com.sportradar.repository;

import java.util.Calendar;
import java.util.List;

import com.sportradar.entities.Goal;
import com.sportradar.entities.Match;
import com.sportradar.entities.Team;

public interface IMatchRepository {
	List<Match> getAllMatchesOnCurse();
	List<Match> getAllMatchesFinished();
	Match getMatchById(Long idMatch);
	Long getGoalsByMatch(Long idMatch);
	Match updateMatch(Match match);
	Match createMatch(Long id, Team homeTeam, Team awayTeam, List<Goal> goalsMatch, Boolean finished, Long minute, Calendar startMatch);
}
