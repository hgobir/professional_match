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
import com.fdm.project.repositories.InstituteRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(value=InstituteController.class)
class InstituteControllerTest {

	private static String URI = "/api/v1/institutes";
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private InstituteRepository instituteRepository;

	@Test
	void testGetInstitute() throws Exception {
		
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
		
		String controlJson = mapToJson(i);
		
		Mockito.when(instituteRepository.getOne(i.getId())).thenReturn(i);
		
		RequestBuilder builder = MockMvcRequestBuilders.get(URI+"/"+i.getId());
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
		
		Institute i2 = new Institute();
		i2.setId(2L);
		i2.setName("i2");
		i2.setInformation("info2");
		i2.setAddress("a2");
		i2.setImage("u2");
		i2.setUser1(1);
		i2.setUser2(2);
		i2.setUser3(3);
		i2.setUser4(4);
		i2.setUser5(5);
		
		List<Institute> instituteList = new ArrayList<>();
		instituteList.add(i);
		instituteList.add(i2);
		
		String controlJson = mapToJson(instituteList);
		
		Mockito.when(instituteRepository.findAll()).thenReturn(instituteList);
		
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
