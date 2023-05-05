package com.sportradar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sportradar.dto.DashBoard;
import com.sportradar.service.IDashBoardService;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private static IDashBoardService dashBoardService;

	public static void main(String[] args) {
		
		formatDashBoard();
		SpringApplication.run(DemoApplication.class, args);
	}
	
	private static void formatDashBoard() {
		DashBoard dashboard = new DashBoard();
		
		try {
			dashboard = dashBoardService.resumeMatches();
			
			if(dashBoardService.dashBoardHasContent(dashboard)) {
				System.out.println("Hay partidos para formatear");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
