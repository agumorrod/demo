package com.sportradar.repository;

import com.sportradar.dto.DashBoard;

public interface IDashBoardRepository {
	Long minute(Long idMatch) throws Exception;
	DashBoard resumeMatches() throws Exception;
	boolean dashBoardHasContent(DashBoard dashBoard) throws Exception;
}
