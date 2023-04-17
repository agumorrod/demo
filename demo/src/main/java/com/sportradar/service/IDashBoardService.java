package com.sportradar.service;

import java.util.List;

import com.sportradar.entities.DashBoard;
import com.sportradar.entities.Match;

public interface IDashBoardService {
	
	// Preguntar cada minuto por los resultados.
	Long minute();
	// Si hay partidos finalizados, mostramos en el resumen de forma ordenada a los requisitos
	DashBoard resumeMatches();
	DashBoard resumeMatches(List<Match> listMatches);
	// Si todos los partidos están finalizados, dejamos de preguntar y mostramos el resumen final del día de hoy.
	
}
