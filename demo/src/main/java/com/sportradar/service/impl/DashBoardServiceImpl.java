package com.sportradar.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportradar.dto.DashBoard;
import com.sportradar.dto.Match;
import com.sportradar.repository.IDashBoardRepository;
import com.sportradar.repository.IMatchRepository;
import com.sportradar.service.IDashBoardService;

@Service
public class DashBoardServiceImpl implements IDashBoardService {
	
	@Autowired
	IDashBoardRepository dashBoardRepository;
	@Autowired
	IMatchRepository matchRepository;
	
	@Override
	public Long minute(Long idMatch) throws Exception{
		Long minute = 0L;
		
		try {
			Match match = matchRepository.getMatchById(idMatch);
			
			if(match!=null) {
				minute = match.getMinute();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		
		return minute;
	}

	@Override
	public DashBoard resumeMatches() throws Exception{
		// Local variables
		DashBoard result = new DashBoard();
		
		List<Match> matchesFinished = matchRepository.getAllMatchesFinished();
		List<Match> matchesUnfinished = matchRepository.getAllMatchesOnCurse();
		
		if(matchesUnfinished!=null && matchesFinished!=null) {
			result.setMatchesFinished(matchesFinished);
			result.setMatchesOnCourse(matchesUnfinished);
		}else if(matchesFinished!=null) {
			result.setMatchesFinished(matchesFinished);
			result.setMatchesOnCourse(new LinkedList<Match>());
		}else {
			result.setMatchesOnCourse(matchesUnfinished);
			result.setMatchesFinished(new LinkedList<Match>());
		}
		 	
		return result;
	}

	@Override
	public boolean dashBoardHasContent(DashBoard dashBoard) throws Exception{
		
		dashBoardRepository.dashBoardHasContent(dashBoard);
		
		if(dashBoard!=null && (dashBoard.getMatchesFinished()!=null || dashBoard.getMatchesOnCourse()!=null)) {
			if(!dashBoard.getMatchesFinished().isEmpty() || dashBoard.getMatchesOnCourse()!=null) {
				return true;
			}
		}
		return false;
	}

}
