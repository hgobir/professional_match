package com.fdm.project.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdm.project.models.User;
import com.fdm.project.repositories.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class)
class UserControllerTest {
	
	private static String URI = "/api/v1/users";
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRepository userRepository;

	@Test
	void testGetUser() throws Exception {
		User u = new User();
		u.setId(1L);
		u.setUsername("test");
		u.setPassword("p");
		u.setName("name");
		u.setEmail("e");
		u.setAge(4);
		u.setInstitute1(1);
		u.setInstitute2(2);
		u.setInstitute3(3);
		u.setInstitute4(4);
		u.setInstitute5(5);
		
		String controlJson = mapToJson(u);
		
		Mockito.when(userRepository.getOne(u.getId())).thenReturn(u);
		
		RequestBuilder builder = MockMvcRequestBuilders.get(URI+"/"+u.getId());
		MvcResult r = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = r.getResponse();
		String outputJson = response.getContentAsString();
		
		assertEquals(controlJson, outputJson);
	}
	
	
	@Test
	void testGetUserList() throws Exception {
		User u1 = new User();
		u1.setId(1L);
		u1.setUsername("test");
		u1.setPassword("p");
		u1.setName("name");
		u1.setEmail("e");
		u1.setAge(4);
		u1.setInstitute1(1);
		u1.setInstitute2(2);
		u1.setInstitute3(3);
		u1.setInstitute4(4);
		u1.setInstitute5(5);
		
		User u2 = new User();
		u2.setId(2L);
		u2.setUsername("test2");
		u2.setPassword("p2");
		u2.setName("name2");
		u2.setEmail("e2");
		u2.setAge(5);
		u2.setInstitute1(1);
		u2.setInstitute2(2);
		u2.setInstitute3(3);
		u2.setInstitute4(4);
		u2.setInstitute5(5);
		
		List<User> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(u2);
		
		String controlJson = mapToJson(userList);
		
		Mockito.when(userRepository.findAll()).thenReturn(userList);
		
		RequestBuilder builder = MockMvcRequestBuilders.get(URI);
		MvcResult r = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = r.getResponse();
		String outputJson = response.getContentAsString();
		
		assertEquals(controlJson, outputJson);
	}
	
	
	private String mapToJson(Object o) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(o);
		
	}

}
