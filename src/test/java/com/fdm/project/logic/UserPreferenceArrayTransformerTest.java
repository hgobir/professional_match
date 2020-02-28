package com.fdm.project.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdm.project.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserPreferenceArrayTransformerTest {

	@Autowired
	private UserPreferenceArrayTransformer uTransformer;
	
	@MockBean
	private UserService userService;

	@Test
	void testProcessUsers() {
		HashMap<Long, List<Integer>> userConstruct = new HashMap<>();
		List<Integer> u1 = new ArrayList<>();
		u1.add(1);
		u1.add(2);
		u1.add(3);
		u1.add(4);
		u1.add(5);
		
		when(userService.getValidUserEntries()).thenReturn(userConstruct);		
		int[][] result = uTransformer.processUsers();
		assertEquals(5, result.length);	
	}
	
	@Test
	void testConvertLongListToArray() {
		List<Long> u1 = new ArrayList<>();
		u1.add(1L);
		u1.add(2L);
		u1.add(3L);
		u1.add(4L);
		u1.add(5L);
		
		long[] result = uTransformer.convertLongListToArray(5, u1);
		assertEquals(5, result.length);	
	}
	
	@Test
	void testConvertSetToList() {
		Set<Long> u1 = new HashSet<>();
		u1.add(1L);
		u1.add(2L);
		u1.add(3L);
		u1.add(4L);
		u1.add(5L);
		
		List<Long> result = uTransformer.convertSetToList(u1);
		assertEquals(ArrayList.class, result.getClass());	
	}
	
	@Test
	void testValidUserIds() {
		HashMap<Long, List<Integer>> userConstruct = new HashMap<>();
		
		List<Integer> u1 = new ArrayList<>();
		u1.add(1);
		u1.add(2);
		u1.add(3);
		u1.add(4);
		u1.add(5);
		userConstruct.put(1L, u1);
		
		when(userService.getValidUserEntries()).thenReturn(userConstruct);		
		List<Long> result = uTransformer.validUserIds();
		assertEquals(1, result.size());	
	}

}
