package com.fdm.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdm.project.models.UserInstituteMatch;
import com.fdm.project.services.UserInstituteMatchService;



@RestController
@RequestMapping("/api/v1/matches")
public class UserInstituteMatchController {
	
	@Autowired
	private UserInstituteMatchService matchingService;
		
	@GetMapping
	public List<UserInstituteMatch> getAllMatches() {

		return matchingService.getAllMatches();
	}
	
	@GetMapping("/{id}")
	public UserInstituteMatch get(@PathVariable("id") long id) {
		
		return matchingService.getSingleMatch(id);
	}

}
