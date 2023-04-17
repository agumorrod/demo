package com.sportradar.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

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
}
