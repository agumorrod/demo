package com.sportradar.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Match implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5656769913069943072L;
	private Long id;
	private Team homeTeam;
	private Team awayTeam;
	private List<Goal> goalsMatch;
	private Boolean finished;
	private Long minute;
	private Calendar startMatch;
	
//	public Match(){
//		this.id = null;
//		this.homeTeam = new Team();
//		this.awayTeam = new Team();
//		this.goalsMatch = new LinkedList<Goal>();
//		this.finished = null;
//		this.minute = null;
//		this.startMatch = null;
//	}
//	
//	public Match(Long id, Team homeTeam, Team awayTeam, List<Goal> goalsMatch, Boolean finished, Long minute, Calendar startMatch){
//		this.id = id;
//		this.homeTeam = homeTeam;
//		this.awayTeam = awayTeam;
//		this.goalsMatch = goalsMatch;
//		this.finished = finished;
//		this.minute = minute;
//		this.startMatch = startMatch;
//	}
}
