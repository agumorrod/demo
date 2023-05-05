package com.sportradar.repository.impl;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportradar.dto.Goal;
import com.sportradar.dto.Match;
import com.sportradar.dto.Team;
import com.sportradar.repository.IMatchRepository;

@Repository
public class MatchRepositoryImpl implements IMatchRepository{
	
	private List<Match> matchList;
	
	@Override
	public List<Match> getAllMatches() throws Exception{
		try {
			return matchList;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Match getMatchById(Long idMatch) throws Exception {
		//Local variables
		Match result = new Match();
		
		if (idMatch!=null) {
			return new Match(idMatch, new Team(0L, "", true), new Team(0L, "", false), new LinkedList<Goal>(), false, 0L, Calendar.getInstance());
		}else {
			return result;
		}
	}

	@Override
	public boolean updateMatch(Match match) throws Exception{
		try {
			return true;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public boolean createMatch(Match match) throws Exception{
		try {
			return true;
		} catch (Exception e) {
			throw new Exception("Error creating match");
		}
	}

	@Override
	public List<Match> getAllMatchesOnCurse() throws Exception {
		try {
			return matchList;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<Match> getAllMatchesFinished() throws Exception {
		try {
			return matchList;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Long getGoalsByMatch(Long idMatch) throws Exception {
		try {
			return 0L;
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
