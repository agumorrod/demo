package com.sportradar.service;

import com.sportradar.entities.DashBoard;

public interface IDashBoardService {
	Long minute();
	DashBoard resumeMatches();
	boolean dashBoardHasContent(DashBoard dashBoard);
}
