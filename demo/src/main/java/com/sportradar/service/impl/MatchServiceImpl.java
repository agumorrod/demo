package com.sportradar.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportradar.entities.Match;
import com.sportradar.repository.IMatchRepository;
import com.sportradar.service.IMatchService;

@Service
public class MatchServiceImpl implements IMatchService {
	
	@Autowired
	private IMatchRepository matchRepository;

	@Override
	public void startMatch(Long idMatch) {
		Match match = matchRepository.getMatchById(idMatch);
		match.setFinished(false);
		match.setMinute(0L);
		match.setStartMatch(Calendar.getInstance());
		
		updateMatch(match);
	}

	@Override
	public void finishMatch(Long idMatch) {
		Match match = matchRepository.getMatchById(idMatch);
		match.setFinished(true);
		match.setMinute(90L);
		
		updateMatch(match);
	}

	@Override
	public Match getMatch(Long idMatch) {
		Match match = matchRepository.getMatchById(idMatch);
		return match;
	}

	@Override
	public Match updateMatch(Match match) {
		Match match1 = new Match();
		match1 = matchRepository.updateMatch(match);
		return match1;
	}

}
