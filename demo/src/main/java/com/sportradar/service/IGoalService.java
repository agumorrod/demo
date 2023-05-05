package com.sportradar.service;

import java.util.List;

import com.sportradar.dto.Goal;

public interface IGoalService {
	Goal getGoalById(Long idGoal);
	List<Goal> goalsTeam(Long idTeam);
	List<Goal> getAllGoals();
	int totalGoalsTeam(Long idTeam); 
}
