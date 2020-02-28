package com.fdm.project.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdm.project.services.InstituteService;

@RunWith(SpringRunner.class)
@SpringBootTest
class InstitutePreferenceArrayTransformerTest {
	
	@Autowired
	private InstitutePreferenceArrayTransformer iTransformer;
	
	@MockBean
	private InstituteService instituteService;

	@Test
	void testProcessInstitutes() {
		HashMap<Long, List<Integer>> instituteConstruct = new HashMap<>();
		List<Integer> i1 = new ArrayList<>();
		i1.add(1);
		i1.add(2);
		i1.add(3);
		i1.add(4);
		i1.add(5);
		
		when(instituteService.getValidInstituteEntries()).thenReturn(instituteConstruct);		
		int[][] result = iTransformer.processInstitutes();
		assertEquals(5, result.length);	
	}

}
