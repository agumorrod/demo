package com.sportradar.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportradar.dto.Goal;
import com.sportradar.repository.IGoalRespository;
import com.sportradar.service.IGoalService;

@Service
public class GoalServiceImpl implements IGoalService {
	
	@Autowired
	private IGoalRespository goalRespository;

	@Override
	public Goal getGoalById(Long idGoal) {
		Goal goal = goalRespository.getGoalById(idGoal);
		
		if(goal!=null) {
			return goal;
		}		
		return new Goal();
	}

	@Override
	public List<Goal> goalsTeam(Long idTeam) {
		List<Goal> goalsList = new LinkedList<Goal>();
		
		goalsList = goalRespository.goalsTeam(idTeam);
		
		if(goalsList!=null && !goalsList.isEmpty()) {
			return (List<Goal>) goalsList.stream().filter(team -> team.getIdTeam().equals(idTeam)).collect(Collectors.toList());
		}
		
		return new LinkedList<Goal>();
	}

	@Override
	public List<Goal> getAllGoals() {
		// Local variables
		List<Goal> goalsList = new LinkedList<Goal>();
		
		goalsList = goalRespository.getAllGoals();
		
		if(goalsList!=null && !goalsList.isEmpty()) {
			return goalsList;
		}
				
		return new LinkedList<Goal>();
	}

	@Override
	public int totalGoalsTeam(Long idTeam) {
		// Local variables
		List<Goal> goalsList = new LinkedList<Goal>();
		int goals = 0;
		
		goalsList = goalRespository.goalsTeam(idTeam);
		
		if(goalsList!=null && !goalsList.isEmpty()) {
			for(Goal g : goalsList) {
				if(g.getIdTeam().equals(idTeam)) {
					goals++;
				}
			}
		}
		
		return goals;
	}

}
