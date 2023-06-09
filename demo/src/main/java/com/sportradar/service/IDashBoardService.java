package com.sportradar.service;

import com.sportradar.dto.DashBoard;

public interface IDashBoardService {
	Long minute(Long idMatch) throws Exception;
	DashBoard resumeMatches() throws Exception;
	boolean dashBoardHasContent(DashBoard dashBoard) throws Exception;
}
