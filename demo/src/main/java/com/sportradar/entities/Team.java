package com.sportradar.entities;

import java.io.Serializable;

public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3866423126093220122L;
	/**
	 * Attribute that contains the object's identifier (pk).
	 */
	private Long id;
	/**
	 * Attribute that contains the name of the team.
	 */
	private String name;
	/**
	 * Attribute that indicates if the team is home or away.
	 */
	private Boolean home;
	
	public Team(String name) {
		this.name = name;
	}

}
