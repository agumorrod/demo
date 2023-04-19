package com.sportradar.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportradar.entities.DashBoard;
import com.sportradar.entities.Match;
import com.sportradar.repository.IMatchRepository;
import com.sportradar.service.IDashBoardService;

@Service
public class DashBoardServiceImpl implements IDashBoardService {
	
	@Autowired
	IMatchRepository matchRepository;
	
	@Override
	public Long minute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DashBoard resumeMatches() {
		// Local variables
		DashBoard result = new DashBoard();
		
		List<Match> matchesFinished = matchRepository.getAllMatchesFinished();
		List<Match> matchesUnfinished = matchRepository.getAllMatchesOnCurse();
		
		if(matchesUnfinished!=null && matchesFinished!=null) {
			result.setMatchesFinished(matchesFinished);
			result.setMatchesUnfinished(matchesUnfinished);
		}else if(matchesFinished!=null) {
			result.setMatchesFinished(matchesFinished);
			result.setMatchesUnfinished(new LinkedList<Match>());
		}else {
			result.setMatchesUnfinished(matchesUnfinished);
			result.setMatchesFinished(new LinkedList<Match>());
		}
		 	
		return result;
	}

	@Override
	public boolean dashBoardHasContent(DashBoard dashBoard) {
		if(dashBoard!=null && (dashBoard.getMatchesFinished()!=null || dashBoard.getMatchesUnfinished()!=null)) {
			if(!dashBoard.getMatchesFinished().isEmpty() || dashBoard.getMatchesUnfinished()!=null) {
				return true;
			}
		}
		return false;
	}

}
