package com.sportradar.repository;

import java.util.List;

import com.sportradar.entities.Match;

public interface IMatchRepository {
	List<Match> getAllMatchesOnCurse();
	List<Match> getAllMatchesFinished();
	Match getMatchById(Long id);
}
