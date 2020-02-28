package com.fdm.project.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdm.project.logic.UserPreferenceArrayTransformer;
import com.fdm.project.models.Institute;
import com.fdm.project.repositories.InstituteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class InstituteServiceTest {
	
	@Autowired
	private InstituteService instituteService;
	
	@MockBean
	private InstituteRepository instituteRepository;
	
	@MockBean
	private UserPreferenceArrayTransformer userPreferenceArrayTransformer;



	@Test
	void testGetValidInstituteEntries() {
		
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
		i2.setName("i");
		i2.setInformation("info");
		i2.setAddress("a");
		i2.setImage("u");
		i2.setUser1(1);
		i2.setUser2(2);
		i2.setUser3(3);
		i2.setUser4(4);
		i2.setUser5(5);
		
		Institute i3 = new Institute();
		i3.setId(3L);
		i3.setName("i");
		i3.setInformation("info");
		i3.setAddress("a");
		i3.setImage("u");
		i3.setUser1(1);
		i3.setUser2(2);
		i3.setUser3(3);
		i3.setUser4(4);
		i3.setUser5(5);
		
		Institute i4 = new Institute();
		i4.setId(4L);
		i4.setName("i");
		i4.setInformation("info");
		i4.setAddress("a");
		i4.setImage("u");
		i4.setUser1(1);
		i4.setUser2(2);
		i4.setUser3(3);
		i4.setUser4(4);
		i4.setUser5(5);
		
		Institute i5 = new Institute();
		i5.setId(5L);
		i5.setName("i");
		i5.setInformation("info");
		i5.setAddress("a");
		i5.setImage("u");
		i5.setUser1(1);
		i5.setUser2(2);
		i5.setUser3(3);
		i5.setUser4(4);
		i5.setUser5(5);
		
		List<Institute> instituteList = new ArrayList<>();
		instituteList.add(i);
		instituteList.add(i2);
		instituteList.add(i3);
		instituteList.add(i4);
		instituteList.add(i5);
		
		List<Long> testUserIds = new ArrayList<>();
		testUserIds.add(10L);
		testUserIds.add(20L);
		testUserIds.add(30L);
		testUserIds.add(40L);
		testUserIds.add(50L);
		
		long[] testUserIdArr = {10L, 20L, 30L, 40L, 50L};

		Mockito.when(instituteRepository.findAll()).thenReturn(instituteList);		
		Mockito.when(userPreferenceArrayTransformer.validUserIds()).thenReturn(testUserIds);
		Mockito.when(userPreferenceArrayTransformer.convertLongListToArray(5, testUserIds)).thenReturn(testUserIdArr);
		
		HashMap<Long, List<Integer>> result = instituteService.getValidInstituteEntries();
		
		assertNotNull(result);
		assertEquals(5, result.size());
	}
	
	@Test
	void testRandomiseInstitutePreferences() {
		
		List<Long> testUserIds = new ArrayList<>();
		testUserIds.add(10L);
		testUserIds.add(20L);
		testUserIds.add(30L);
		testUserIds.add(40L);
		testUserIds.add(50L);
		
		long[] testUserIdArr = {10L, 20L, 30L, 40L, 50L};
		
		Mockito.when(userPreferenceArrayTransformer.validUserIds()).thenReturn(testUserIds);
		Mockito.when(userPreferenceArrayTransformer.convertLongListToArray(5, testUserIds)).thenReturn(testUserIdArr);
		
		List<Integer> result = instituteService.randomiseInstitutePreferences();
		
		assertNotNull(result);
		assertEquals(5, result.size());
		
		boolean equal = true;
		
		for(int i =0; i < testUserIdArr.length; i++) {
			
			Integer instituteChoice = Math.toIntExact(testUserIdArr[i]);
			
			if(!result.contains(instituteChoice)) {
				equal = false;
				break;
			}
		}
		assertTrue(equal);		
	}

}
