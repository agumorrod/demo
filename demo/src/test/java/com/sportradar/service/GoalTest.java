package com.sportradar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sportradar.dto.Goal;
import com.sportradar.repository.IGoalRespository;
import com.sportradar.service.impl.GoalServiceImpl;

/**
 * Test class for a goals's service.
 * @author agumorrod
 * 
 */
@ExtendWith(MockitoExtension.class)
public class GoalTest {
	
	@Mock
	/**
	 * DAO's goals to test.
	 */
	IGoalRespository goalRespository;
	
	@InjectMocks
	/**
	 * Service's goals to test.
	 */
	GoalServiceImpl goalServiceImpl;
	
	@BeforeEach
	void loadBefore() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void test_getAllGoals(){
		List<Goal> goalList = new LinkedList<Goal>();
		
		goalList.add(new Goal(1L, 1L, 21L, "Goleador del equipo 1"));
		goalList.add(new Goal(2L, 1L, 46L, "Goleador del equipo 1"));
		goalList.add(new Goal(3L, 10L, 89L, "Goleador del equipo 10"));
		goalList.add(new Goal(4L, 2L, 2L, "Goleador del equipo 2"));
		goalList.add(new Goal(5L, 9L, 63L, "Goleador del equipo 9"));
		goalList.add(new Goal(6L, 3L, 13L, "Goleador del equipo 3"));
		
		Mockito.when(goalRespository.getAllGoals()).thenReturn(goalList);
		assertEquals(goalList, goalServiceImpl.getAllGoals());
		
		Mockito.when(goalRespository.getAllGoals()).thenReturn(null);
		assertNotNull(goalServiceImpl.getAllGoals());
	}
	
	@Test
	public void test_goalsTeam() {
		List<Goal> goalList = new LinkedList<Goal>();
		
		goalList.add(new Goal(1L, 1L, 21L, "Goleador del equipo 1"));
		goalList.add(new Goal(2L, 1L, 46L, "Goleador del equipo 1"));
		goalList.add(new Goal(3L, 10L, 89L, "Goleador del equipo 10"));
		goalList.add(new Goal(4L, 2L, 2L, "Goleador del equipo 2"));
		goalList.add(new Goal(5L, 9L, 63L, "Goleador del equipo 9"));
		goalList.add(new Goal(6L, 3L, 13L, "Goleador del equipo 3"));
		
		Long idTeam = 1L;
		
		List<Goal> goalListTeam = new LinkedList<Goal>();
		
		goalListTeam.add(new Goal(1L, 1L, 21L, "Goleador del equipo 1"));
		goalListTeam.add(new Goal(2L, 1L, 46L, "Goleador del equipo 1"));
		
		Mockito.when(goalRespository.goalsTeam(idTeam)).thenReturn(null);
		assertNotNull(goalServiceImpl.goalsTeam(idTeam));
		
		Mockito.when(goalRespository.goalsTeam(idTeam)).thenReturn(goalList);
		assertEquals(goalListTeam, goalServiceImpl.goalsTeam(idTeam));
	}
	
	@Test
	public void test_getGoalById() {
		Long idGoal = 5L;
		
		Goal goal = new Goal(5L, 9L, 63L, "Goleador del equipo 9");
		
		Mockito.when(goalRespository.getGoalById(idGoal)).thenReturn(goal);
		assertEquals(goal, goalServiceImpl.getGoalById(idGoal));
		
		Mockito.when(goalRespository.getGoalById(idGoal)).thenReturn(null);
		assertNotNull(goalServiceImpl.getGoalById(idGoal));
	}
	
	@Test
	public void test_totalGoalsTeam() {
		int goals = 2;
		Long idTeam = 1L;
		List<Goal> goalListTeam = new LinkedList<Goal>();
		
		goalListTeam.add(new Goal(1L, 1L, 21L, "Goleador del equipo 1"));
		goalListTeam.add(new Goal(2L, 1L, 46L, "Goleador del equipo 1"));
		
		Mockito.when(goalRespository.goalsTeam(idTeam)).thenReturn(null);
		assertNotNull(goalServiceImpl.totalGoalsTeam(idTeam));
		
		Mockito.when(goalRespository.goalsTeam(idTeam)).thenReturn(null);
		assertEquals(0,goalServiceImpl.totalGoalsTeam(idTeam));
		
		Mockito.when(goalRespository.goalsTeam(idTeam)).thenReturn(goalListTeam);
		assertEquals(goals, goalServiceImpl.totalGoalsTeam(idTeam));
	}

}
