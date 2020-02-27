package com.fdm.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fdm.project.models.Institute;
import com.fdm.project.repositories.InstituteRepository;




@RestController
@RequestMapping("/api/v1/institutes")
public class InstituteController {

	
	@Autowired
	private InstituteRepository instituteRepository;
	
	@GetMapping
	public List<Institute> list() {
		return instituteRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Institute institute) {
		instituteRepository.save(institute);
	}
	
	@GetMapping("/{id}")
	public Institute get(@PathVariable("id") long id) {
		return instituteRepository.getOne(id);
	}
	
	
	
}
