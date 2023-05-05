package com.sportradar.repository.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportradar.dto.Goal;
import com.sportradar.repository.IGoalRespository;

@Repository
public class GoalRespositoryImpl implements IGoalRespository {
	
	private List<Goal> goalsList;

	@Override
	public List<Goal> goalsTeam(Long idTeam) {
		if(goalsList.isEmpty()) {
			return goalsList;
		}
		return new LinkedList<Goal>();
	}

	@Override
	public int totalGoalsTeam(Long idTeam) {
		// Local variables
		int goals = 0;
		
		for(Goal g : goalsList) {
			if(g.getIdTeam().equals(idTeam)) {
				goals++;
			}
		}
		
		return goals;
	}

	@Override
	public Goal getGoalById(Long idGoal) {
		return new Goal(idGoal, 0L, -1L, "");
	}

	@Override
	public List<Goal> getAllGoals() {
		return goalsList;
	}
}
