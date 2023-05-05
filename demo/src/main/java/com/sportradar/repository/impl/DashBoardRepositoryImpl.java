package com.sportradar.repository.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportradar.dto.DashBoard;
import com.sportradar.dto.Match;
import com.sportradar.repository.IDashBoardRepository;
import com.sportradar.repository.IMatchRepository;

@Repository
public class DashBoardRepositoryImpl implements IDashBoardRepository {
	
	@Autowired
	private IMatchRepository matchRepository;

	@Override
	public Long minute(Long idMatch) throws Exception {
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
	public DashBoard resumeMatches() throws Exception {
		DashBoard ret = new DashBoard();
		
		try {
			ret.setMatchesFinished(matchRepository.getAllMatchesFinished());
			ret.setMatchesOnCourse(matchRepository.getAllMatchesOnCurse());
			ret.setDate(Calendar.getInstance());
		} catch (Exception e) {
			throw new Exception();
		}
		
		return ret;
	}

	@Override
	public boolean dashBoardHasContent(DashBoard dashBoard) throws Exception {
		DashBoard d = new DashBoard();
		
		try {
			d = resumeMatches();
			
			if(d!=null && ((d.getMatchesFinished()!=null && !d.getMatchesFinished().isEmpty()) || (d.getMatchesOnCourse()!=null && !d.getMatchesOnCourse().isEmpty()))) {
				return true;
			}
			
		} catch (Exception e) {
			throw new Exception();
		}
		
		return false;
	}

}
