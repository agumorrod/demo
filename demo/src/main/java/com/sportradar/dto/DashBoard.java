package com.sportradar.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import lombok.*;

/**
 * Class that mapping an dashboard object.
 * @author agumorrod
 *
 */
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Data
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
	 * Attribute that contains the list of matches on course of the day.
	 */
	private List<Match> matchesOnCourse;
	/**
	 * Attribute that contains the current date.
	 */
	private Calendar date;
	
//	public DashBoard() {
//		matchesFinished = new LinkedList<Match>();
//		matchesUnfinished = new LinkedList<Match>();
//		date = Calendar.getInstance();
//	}
	
	public DashBoard(LinkedList<Match> matchesFinished, LinkedList<Match> matchesOnCourse) {
		this.matchesFinished = matchesFinished;
		this.matchesOnCourse = matchesOnCourse;
		date = Calendar.getInstance();
	}
}
