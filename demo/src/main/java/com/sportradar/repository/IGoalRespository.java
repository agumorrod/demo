package com.sportradar.repository;

import java.util.List;

import com.sportradar.entities.Goal;

public interface IGoalRespository {
	List<Goal> goalsTeam(Long idTeam);
	int totalGoalsTeam(Long idTeam);
}
