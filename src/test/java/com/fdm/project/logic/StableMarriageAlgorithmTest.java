package com.fdm.project.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StableMarriageAlgorithmTest {
	
	private StableMarriageAlgorithm sb;
	
	
	@BeforeEach
	void setUp() throws Exception {
		sb = new StableMarriageAlgorithm();
	}

	@AfterEach
	void tearDown() throws Exception {
		sb = null;
	}

	@Test
	void testEqualNumberOfPairsGivenArraySize() {
	  int[][] userPrefs = {{1,9,7,8,6,10,0},{2,10,8,7,6,9,0},{3,7,10,6,9,8,0},{4,10,7,9,8,6,0},{5,9,6,7,8,10,0}};
	  int[][] institutePrefs = {{6,4,2,5,3,1,0},{7,2,1,4,3,5,0},{8,1,3,5,4,2,0},{9,4,1,3,2,5,0},{10,2,5,1,3,4,0}};
      Map<Integer,Integer> result = sb.execute(userPrefs, institutePrefs);
      assertEquals(5, result.size());
	}
	
	
	@Test
	void testPairsCreatedIsTheSame() {
	  int[][] userPrefs = {{1,9,7,8,6,10,0},{2,10,8,7,6,9,0},{3,7,10,6,9,8,0},{4,10,7,9,8,6,0},{5,9,6,7,8,10,0}};
	  int[][] institutePrefs = {{6,4,2,5,3,1,0},{7,2,1,4,3,5,0},{8,1,3,5,4,2,0},{9,4,1,3,2,5,0},{10,2,5,1,3,4,0}};
      Map<Integer, Integer> result = sb.execute(userPrefs, institutePrefs);
      Map<Integer, Integer> control = new HashMap<Integer, Integer>();
      control.put(1, 9);
      control.put(2, 10);
      control.put(3, 8);
      control.put(4, 7);
      control.put(5, 6);
      assertEquals(control.get(1), result.get(1));
      assertEquals(control.get(2), result.get(2));
      assertEquals(control.get(3), result.get(3));
      assertEquals(control.get(4), result.get(4));
      assertEquals(control.get(5), result.get(5));
	}	
	
	
	@Test
	void testStability() {
	  int[][] userPrefs = {{1,9,7,8,6,10,1},{2,10,8,7,6,9,1},{3,7,10,6,9,8,1},{4,10,7,9,8,6,1},{5,9,6,7,8,10,1}};
      boolean result = sb.isMatchStable(userPrefs);
      assertTrue(result);
	}
	
	@Test
	void testMatchToggle() {
	  int[][] institutePrefs = {{6,4,2,5,3,1,0},{7,2,1,4,3,5,0},{8,1,3,5,4,2,0},{9,4,1,3,2,5,0},{10,2,5,1,3,4,0}};
      sb.toggleInstituteMatchInd(6, institutePrefs);
      assertEquals(1, institutePrefs[0][6]);
	}	
	
	@Test
	void testPreferenceResolver() {
	  int[][] institutePrefs = {{6,4,2,5,3,1,0},{7,2,1,4,3,5,0},{8,1,3,5,4,2,0},{9,4,1,3,2,5,0},{10,2,5,1,3,4,0}};
      boolean result = sb.preferenceResolver(2, 4, 6, institutePrefs);
      assertTrue(result);
	}	
	
	
	
	
}
