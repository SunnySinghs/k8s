package com.sourabh.java.springbootapp.contoller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@RequestMapping("/teamInfo")
	public String getTeamInfo() {
		return teamName + " has caoch "+ coachName;
	}
	
	@RequestMapping("/hello")
	public String getFortune() {
		return "Hello";
	}
}
