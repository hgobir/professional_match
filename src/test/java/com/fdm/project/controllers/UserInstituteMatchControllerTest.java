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
import com.fdm.project.models.Institute;
import com.fdm.project.models.User;
import com.fdm.project.models.UserInstituteMatch;
import com.fdm.project.services.UserInstituteMatchService;


@RunWith(SpringRunner.class)
@WebMvcTest(value=UserInstituteMatchController.class)
class UserInstituteMatchControllerTest {

	private static String URI = "/api/v1/matches";
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserInstituteMatchService matchingService;

	@Test
	void testGetMatch() throws Exception {
		

		Institute i = new Institute();
		i.setId(1L);
		i.setName("i");
		i.setInformation("info");
		i.setAddress("a");
		i.setImage("u");
		i.setUser1(1);
		i.setUser2(2);
		i.setUser3(3);
		i.setUser4(4);
		i.setUser5(5);
		
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
		
		
		UserInstituteMatch m = new UserInstituteMatch(u, i);

		String controlJson = mapToJson(m);
		
		Mockito.when(matchingService.getSingleMatch(u.getId())).thenReturn(m);
		
		RequestBuilder builder = MockMvcRequestBuilders.get(URI+"/"+u.getId());
		MvcResult r = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response = r.getResponse();
		String outputJson = response.getContentAsString();
		
		assertEquals(controlJson, outputJson);
	}
	
	
	@Test
	void testGetInstituteList() throws Exception {
		
		Institute i = new Institute();
		i.setId(1L);
		i.setName("i");
		i.setInformation("info");
		i.setAddress("a");
		i.setImage("u");
		i.setUser1(1);
		i.setUser2(2);
		i.setUser3(3);
		i.setUser4(4);
		i.setUser5(5);
		
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
		
		
		UserInstituteMatch m = new UserInstituteMatch(u, i);
		
		Institute i2 = new Institute();
		i2.setId(1L);
		i2.setName("i");
		i2.setInformation("info");
		i2.setAddress("a");
		i2.setImage("u");
		i2.setUser1(1);
		i2.setUser2(2);
		i2.setUser3(3);
		i2.setUser4(4);
		i2.setUser5(5);
		
		User u2 = new User();
		u2.setId(1L);
		u2.setUsername("test");
		u2.setPassword("p");
		u2.setName("name");
		u2.setEmail("e");
		u2.setAge(4);
		u2.setInstitute1(1);
		u2.setInstitute2(2);
		u2.setInstitute3(3);
		u2.setInstitute4(4);
		u2.setInstitute5(5);
		
		UserInstituteMatch m2 = new UserInstituteMatch(u2, i2);

		List<UserInstituteMatch> matchList = new ArrayList<>();
		matchList.add(m);
		matchList.add(m2);
		
		String controlJson = mapToJson(matchList);
		
		Mockito.when(matchingService.getAllMatches()).thenReturn(matchList);
		
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
