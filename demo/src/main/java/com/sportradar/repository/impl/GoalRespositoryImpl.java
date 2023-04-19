package com.sportradar.repository.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportradar.entities.Goal;
import com.sportradar.repository.IGoalRespository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class GoalRespositoryImpl implements IGoalRespository {
	
	private List<Goal> goalsList;
	
	public GoalRespositoryImpl() {
		goalsList = new LinkedList<Goal>();
		
		load();
	}

	private void load() {
		goalsList.set(0, new Goal(1L, 1L, 3L, "Scorer 1"));
		goalsList.set(1, new Goal(2L, 1L, 3L, "Scorer 1"));
		goalsList.set(2, new Goal(2L, 1L, 3L, "Scorer 1"));
		goalsList.set(3, new Goal(3L, 1L, 3L, "Scorer 1"));
		goalsList.set(4, new Goal(5L, 1L, 3L, "Scorer 1"));
		goalsList.set(5, new Goal(5L, 1L, 3L, "Scorer 1"));
		goalsList.set(6, new Goal(5L, 1L, 3L, "Scorer 1"));
		goalsList.set(7, new Goal(7L, 1L, 3L, "Scorer 1"));
		goalsList.set(8, new Goal(8L, 1L, 3L, "Scorer 1"));
		goalsList.set(9, new Goal(9L, 1L, 3L, "Scorer 1"));
		goalsList.set(10, new Goal(9L, 1L, 3L, "Scorer 1"));
		
	}

	@Override
	public List<Goal> goalsTeam(Long idTeam) {
		
		return (List<Goal>) goalsList.stream().filter(team -> team.getId() == idTeam).findAny().get();
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
}
