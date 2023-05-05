package com.sportradar.service;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sportradar.dto.Goal;
import com.sportradar.dto.Match;
import com.sportradar.dto.Team;
import com.sportradar.repository.IMatchRepository;
import com.sportradar.service.impl.MatchServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MatchServiceTest {
	
	@Mock
	private IMatchRepository matchRepository;
	
	@InjectMocks
	private MatchServiceImpl matchService;
	
	private List<Goal> goalsList;
	
	private List<Match> matchesList;
	
	private List<Match> matchesOnCourse;
	
	private List<Match> matchesFinished;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		createGoalsList();
	}
	
	private void createGoalsList() {
		goalsList = new LinkedList<Goal>();
		matchesList = new LinkedList<Match>();
		matchesFinished = new LinkedList<Match>();
		matchesOnCourse = new LinkedList<Match>();
		
		goalsList.add(0, new Goal(1L, 1L, 3L, "Scorer 1"));
		goalsList.add(1, new Goal(2L, 1L, 4L, "Scorer 1"));
		goalsList.add(2, new Goal(3L, 1L, 5L, "Scorer 1"));
		goalsList.add(3, new Goal(4L, 1L, 6L, "Scorer 1"));
		goalsList.add(4, new Goal(5L, 1L, 7L, "Scorer 1"));
		goalsList.add(5, new Goal(6L, 10L, 8L, "Scorer 1"));
		goalsList.add(6, new Goal(7L, 10L, 9L, "Scorer 1"));
		goalsList.add(7, new Goal(8L, 10L, 10L, "Scorer 1"));
		goalsList.add(8, new Goal(9L, 10L, 31L, "Scorer 1"));
		goalsList.add(9, new Goal(10L, 10L, 32L, "Scorer 1"));
		goalsList.add(10, new Goal(11L, 10L, 33L, "Scorer 1"));
	}
	
	private void chargeData() {
		Match match1 = new Match(1L, new Team(1L, "Mexico", true), new Team(10L, "Canada", false), goalsList, false, 3L, Calendar.getInstance());
		matchesList.add(match1);
		matchesOnCourse.add(match1);
		match1 = new Match(1L, new Team(2L, "Spain", true), new Team(9L, "Brazil", false), goalsList, false, 58L, Calendar.getInstance());
		matchesList.add(match1);
		matchesOnCourse.add(match1);
		match1 = new Match(1L, new Team(3L, "Germany", true), new Team(8L, "France", false), goalsList, true, 90L, Calendar.getInstance());
		matchesList.add(match1);
		matchesFinished.add(match1);
		match1 = new Match(1L, new Team(4L, "Uruguay", true), new Team(7L, "Italy", false), goalsList, false, 87L, Calendar.getInstance());
		matchesList.add(match1);
		matchesOnCourse.add(match1);
		match1 = new Match(1L, new Team(5L, "Argentina", true), new Team(6L, "Australia", false), goalsList, true, 90L, Calendar.getInstance());
		matchesList.add(match1);
		matchesFinished.add(match1);
	}

	@Test
	public void getMatchByIdTest() throws Exception {
		Match match1 = new Match(1L, new Team(1L, "Mexico", true), new Team(10L, "Canada", false), goalsList, false, 3L, Calendar.getInstance());
		
		Mockito.when(matchRepository.getMatchById(1L)).thenReturn(match1);
		Assertions.assertEquals(match1, matchService.getMatch(1L));
		
		Mockito.when(matchRepository.getMatchById(1L)).thenThrow(new Exception());
		Assertions.assertThrowsExactly(Exception.class, ()->matchService.getMatch(1L));
	}
	
	@Test
	public void createMatch_test() throws Exception {
		Match match1 = new Match(1L, new Team(1L, "Mexico", true), new Team(10L, "Canada", false), goalsList, false, 3L, Calendar.getInstance());
		
		Mockito.when(matchRepository.createMatch(match1)).thenReturn(true);
		Assertions.assertEquals(true, matchService.createMatch(match1));
		
		Mockito.when(matchRepository.createMatch(match1)).thenThrow(new Exception());
		Assertions.assertThrowsExactly(Exception.class, ()->matchService.createMatch(match1));
	}
	
	@Test
	public void getAllMatchesOnCurse() throws Exception{
		chargeData();
	
		Mockito.when(matchRepository.getAllMatches()).thenReturn(matchesList);
		Assertions.assertEquals(matchesOnCourse, matchService.getAllMatchesOnCurse());
		
		Mockito.when(matchRepository.getAllMatches()).thenThrow(new Exception());
		Assertions.assertThrowsExactly(Exception.class, ()->matchService.getAllMatchesOnCurse());
	}
	
	@Test
	public void getAllMatchesFinished() throws Exception{
		chargeData();
	
		Mockito.when(matchRepository.getAllMatches()).thenReturn(matchesList);
		Assertions.assertEquals(matchesFinished, matchService.getAllMatchesFinished());
		
		Mockito.when(matchRepository.getAllMatches()).thenThrow(new Exception());
		Assertions.assertThrowsExactly(Exception.class, ()->matchService.getAllMatchesFinished());
	}

	
}
