package com.sportradar.repository.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sportradar.dto.Team;
import com.sportradar.repository.ITeamRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
@Service
@Controller
public class TeamRepositoryImpl implements ITeamRepository {
	
	private List<Team> listTeams;
	
	public TeamRepositoryImpl() {
		listTeams = new LinkedList<Team>();
		
		loadData();
	}

	private void loadData() {
		listTeams.add(new Team(1L, "Mexico", true));
		listTeams.add(new Team(2L, "Spain", true));
		listTeams.add(new Team(3L, "Germany", true));
		listTeams.add(new Team(4L, "Uruguay", true));
		listTeams.add(new Team(5L, "Argentina", true));
		listTeams.add(new Team(6L, "Australia", false));
		listTeams.add(new Team(7L, "Italy", false));
		listTeams.add(new Team(8L, "France", false));
		listTeams.add(new Team(9L, "Brazil", false));
		listTeams.add(new Team(10L, "Canada", false));
	}

	@Override
	public List<Team> getAllTeams() {
		return listTeams;
	}

	@Override
	public Team getTeamById(Long id) {
		return listTeams.stream().filter(team -> team.getId() == id).findFirst().get();
	}

}
