package com.fdm.project.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fdm.project.services.InstituteService;


@Component
@Configuration
public class InstitutePreferenceArrayTransformer {
	
	
	@Autowired
	private InstituteService instituteService;
	
	public int[][] allInstitutePreferences = new int[5][7];
	
	
	public int[][] processInstitutes() {
		
		HashMap<Long, List<Integer>> instituteConstruct = new HashMap<>();
		instituteConstruct = instituteService.getValidInstituteEntries();
		int count = 0;
		
		for(Entry<Long, List<Integer>> mapEntry : instituteConstruct.entrySet()) {
			
			Long instituteId = mapEntry.getKey();
			List<Integer> instituteSelection = mapEntry.getValue();
			
			int[] specificInstitutePreference = convertIntegerListToArray(7, instituteSelection);
			
			int id = Math.toIntExact(instituteId);
			
			specificInstitutePreference[0] = id;
			
			allInstitutePreferences[count] = specificInstitutePreference;
			
			count++;
		}
		return allInstitutePreferences;
	}
	
	//NEED TO REFACTOR AS DUPLICATED
	public int[] convertIntegerListToArray(int arrayLength, List<Integer> list) {
		
		int[] arrayForm = new int[arrayLength];
				
		for(int i = 0; i < list.size(); i++) {
			
			arrayForm[i + 1] = list.get(i);	
		}
		return arrayForm;	
	}

}
