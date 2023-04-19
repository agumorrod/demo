package com.sportradar.service;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sportradar.entities.Goal;
import com.sportradar.entities.Match;
import com.sportradar.entities.Team;
import com.sportradar.repository.IMatchRepository;

@ExtendWith(MockitoExtension.class)
public class MatchServiceTest {
	
	@Mock
	private IMatchRepository matchRepository;
	
	@InjectMocks
	private IMatchService matchService;
	
	public void getMatchByIdTest() {
		
		List<Goal> goalsList = new LinkedList<Goal>();
		
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
		
		Match match1 = new Match(1L, new Team(1L, "Mexico", true), new Team(10L, "Canada", false), goalsList, false, 3L, Calendar.getInstance());
		
		Match match2 = matchRepository.getMatchById(1L);
		
		Mockito.when(matchRepository.createMatch(1L, new Team(1L, "Mexico", true), new Team(10L, "Canada", false), goalsList, false, 3L, Calendar.getInstance()));
		
		Assertions.assertEquals(match1, match2);
	}
}
