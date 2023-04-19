package com.sportradar.repository.impl;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportradar.entities.Goal;
import com.sportradar.entities.Match;
import com.sportradar.entities.Team;
import com.sportradar.repository.IGoalRespository;
import com.sportradar.repository.IMatchRepository;
import com.sportradar.repository.ITeamRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class MatchRepositoryImpl implements IMatchRepository {
	
	@Autowired
	private ITeamRepository teamRepository;
	@Autowired
	private IGoalRespository goalRespository;
	
	private List<Match> matchesOnCurse;
	private List<Match> matchesFinished;
	
	public MatchRepositoryImpl() {
		matchesOnCurse = new LinkedList<Match>();
		matchesFinished = new LinkedList<Match>();
		
		loadData();
	}
	
	private void loadData() {
		// Local variables
		
		matchesOnCurse.add(new Match(1L, teamRepository.getTeamById(1L), teamRepository.getTeamById(10L), goalRespository.goalsTeam(1L),false, 23L, Calendar.getInstance()));
		matchesFinished.add(new Match(2L, teamRepository.getTeamById(2L), teamRepository.getTeamById(9L), goalRespository.goalsTeam(2L),true, 90L, Calendar.getInstance()));
		
	}

	@Override
	public List<Match> getAllMatchesOnCurse() {
		return matchesOnCurse;
	}

	@Override
	public List<Match> getAllMatchesFinished() {
		return matchesFinished;
	}

	@Override
	public Match getMatchById(Long idMatch) {
		//Local variables
		Match result = new Match();
		
		if(matchesOnCurse!=null && !matchesOnCurse.isEmpty()) {
			return matchesOnCurse.stream().filter(match -> match.getId() == idMatch).findFirst().get();
		}else if(matchesOnCurse!=null && !matchesFinished.isEmpty()) {
			return matchesFinished.stream().filter(match -> match.getId() == idMatch).findFirst().get();
		}else {
			return result;
		}
	}

	@Override
	public Long getGoalsByMatch(Long idMatch) {
		//Local variables
		Match result = new Match();
		Long goals = 0L;
		
		result = getMatchById(idMatch);
		
		for(Goal g : result.getGoalsMatch()) {
			if(g!=null) {
				goals ++;
			}
		}
		
		return goals;
	}

	@Override
	public Match updateMatch(Match match) {
		Match matchUpdated = getMatchById(match.getId());
		
		matchUpdated.setAwayTeam(match.getAwayTeam());
		matchUpdated.setFinished(match.getFinished());
		matchUpdated.setGoalsMatch(match.getGoalsMatch());
		matchUpdated.setHomeTeam(match.getHomeTeam());
		matchUpdated.setMinute(match.getMinute());
		matchUpdated.setStartMatch(match.getStartMatch());
		
		return matchUpdated;
	}

	@Override
	public Match createMatch(Long id, Team homeTeam, Team awayTeam, List<Goal> goalsMatch, Boolean finished, Long minute, Calendar startMatch) {
		Match match = new Match();
		
		match.setId(id);
		match.setAwayTeam(awayTeam);
		match.setFinished(false);
		match.setGoalsMatch(goalsMatch);
		match.setHomeTeam(homeTeam);
		match.setMinute(minute);
		match.setStartMatch(Calendar.getInstance());
		
		return match;
	}

}
