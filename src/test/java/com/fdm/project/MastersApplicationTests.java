package com.fdm.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fdm.project.controllers.UserController;
import com.fdm.project.models.User;
import com.fdm.project.repositories.UserRepository;
import com.fdm.project.services.UserService;

@SpringBootTest
class MastersApplicationTests {
	
	@Autowired
	private UserController userController;
	
	@MockBean
	private UserRepository userRepository;
	

	@BeforeEach
	void setUp() throws Exception {
		userController = new UserController();
	}

	@AfterEach
	void tearDown() throws Exception {
		userController = null;
	}

	@Test
	void testGetUsers() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User(), new User()).collect(Collectors.toList()));
		assertEquals(2, userController.list().size());
	}
	

//
//	@Test
//	void contextLoads() {
//	}

}
