package com.sportradar.repository;

import java.util.List;

import com.sportradar.dto.Team;

public interface ITeamRepository {

	List<Team> getAllTeams();
	Team getTeamById(Long id);
}
