package com.sportradar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sportradar.service.IDashBoardService;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private IDashBoardService dashBoardService;

	@Test
	void contextLoads() throws Exception {
		dashBoardService.resumeMatches();
		
	}

}
