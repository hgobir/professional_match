package com.fdm.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fdm.project.models.User;
import com.fdm.project.repositories.UserRepository;
import com.fdm.project.services.UserService;




@RestController
@RequestMapping("/api/v1/users")
@Configuration
//@ComponentScan("com.professionmatch.backend.service")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> list() {
		return userRepository.findAll();
	}


	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@GetMapping("/{id}")
	public User get(@PathVariable("id") long id) {
		return userRepository.getOne(id);
	}
	
	
	
	

}
