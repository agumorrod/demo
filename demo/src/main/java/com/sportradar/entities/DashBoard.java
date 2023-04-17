package com.sportradar.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that mapping an dashboard object.
 * @author agumorrod
 *
 */
public class DashBoard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8309115793314111986L;

	/**
	 * Attribute that contains the list of matches finished of the day.
	 */
	private List<Match> matchesFinished;
	/**
	 * Attribute that contains the list of matches unfinished of the day.
	 */
	private List<Match> matchesUnfinished;
	/**
	 * Attribute that contains the current date.
	 */
	private Calendar date;
	
	public DashBoard() {
		matchesFinished = new LinkedList<Match>();
		matchesUnfinished = new LinkedList<Match>();
		date = Calendar.getInstance();
	}
	
	public DashBoard(LinkedList<Match> matchesFinished, LinkedList<Match> matchesUnfinished) {
		this.matchesFinished = matchesFinished;
		this.matchesUnfinished = matchesUnfinished;
		date = Calendar.getInstance();
	}
}
