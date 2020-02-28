package com.fdm.project.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreferenceArrayTransformerTest {
	
	private PreferenceArrayTransformer transformer;

	@BeforeEach
	void setUp() throws Exception {
		transformer = new PreferenceArrayTransformer();
	}

	@AfterEach
	void tearDown() throws Exception {
		transformer = null;
	}

	@Test
	void testListToArrayConversionSize() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		int[] result = transformer.convertIntegerListToArray(5, list);
		assertEquals(5, result.length);
	}
	
	@Test
	void testListToArrayConversionData() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		int[] result = transformer.convertIntegerListToArray(5, list);
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
		assertEquals(2, result[2]);
		assertEquals(3, result[3]);
		assertEquals(0, result[4]);
	}

}
