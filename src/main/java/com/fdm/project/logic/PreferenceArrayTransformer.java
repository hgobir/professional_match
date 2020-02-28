package com.fdm.project.logic;

import java.util.List;

public class PreferenceArrayTransformer {
	
	
	public int[] convertIntegerListToArray(int arrayLength, List<Integer> list) {
		
		int[] arrayForm = new int[arrayLength];
				
		for(int i = 0; i < list.size(); i++) {
			
			arrayForm[i + 1] = list.get(i);	
		}
		return arrayForm;	
	}
	
	

}
