package com.sportradar.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportradar.dto.Match;
import com.sportradar.repository.IMatchRepository;
import com.sportradar.service.IMatchService;

@Service
public class MatchServiceImpl implements IMatchService{
	
	@Autowired
	private IMatchRepository matchRepository;
	
	@Override
	public boolean createMatch(Match newMatch) throws Exception {
		boolean ret;
		try {
			ret = matchRepository.createMatch(newMatch);
		} catch (Exception e) {
			throw new Exception();
		}
		return ret;
	}

	@Override
	public void finishMatch(Long idMatch) throws Exception {
		try {
			Match match = matchRepository.getMatchById(idMatch);
			match.setFinished(true);
			match.setMinute(90L);
			
			updateMatch(match);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Match getMatch(Long idMatch) throws Exception{
		Match match;
		try {
			match = matchRepository.getMatchById(idMatch);
		} catch (Exception e) {
			throw new Exception();
		}
		if(match!=null) {
			return match;
		}
		return new Match();
	}

	@Override
	public boolean updateMatch(Match match) throws Exception {
		boolean ret = false;
		try {
			ret = matchRepository.updateMatch(match);
		} catch (Exception e) {
			throw new Exception();
		}
		return ret;
	}

	@Override
	public List<Match> getAllMatchesOnCurse() throws Exception{
		try {
			return matchRepository.getAllMatches().stream().filter(match -> !match.getFinished()).collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<Match> getAllMatchesFinished() throws Exception{
		try {
			return matchRepository.getAllMatches().stream().filter(match -> match.getFinished()).collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Long getGoalsByMatch(Long idMatch) throws Exception{
		try {
			return matchRepository.getGoalsByMatch(idMatch);
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
