package com.sportradar.service.impl;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DashBoard resumeMatches(List<Match> listMatches) {
		// Local variables
		DashBoard result = new DashBoard();
		
		List<Match> matchesFinished = matchRepository.getAllMatchesFinished();
		List<Match> matchesUnfinished = matchRepository.getAllMatchesOnCurse();
		
		if(matchesUnfinished!=null && !matchesUnfinished.isEmpty() && (matchesFinished==null || matchesFinished.isEmpty())) {
			// Tratar lista de inacabados
		}else if((matchesUnfinished==null || matchesUnfinished.isEmpty()) && matchesFinished!=null && !matchesFinished.isEmpty()) {
			// Tratar lista de acabados
		}else {
			// Tratar las 2 listas
		}
		 	
		return result;
	}

}
