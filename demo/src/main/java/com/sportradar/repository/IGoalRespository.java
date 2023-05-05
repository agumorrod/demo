package com.sportradar.repository;

import java.util.List;

import com.sportradar.dto.Goal;

public interface IGoalRespository {
	List<Goal> goalsTeam(Long idTeam);
	int totalGoalsTeam(Long idTeam);
	Goal getGoalById(Long idGoal);
	List<Goal> getAllGoals();
}
