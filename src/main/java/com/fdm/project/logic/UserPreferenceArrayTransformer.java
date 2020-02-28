package com.fdm.project.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fdm.project.services.UserService;


@Component
@Configuration
public class UserPreferenceArrayTransformer extends PreferenceArrayTransformer {
	
	
	@Autowired
	private UserService userService;
	
	public int[][] allUserPreferences = new int[5][7];
	
	
	public int[][] processUsers() {
		
		HashMap<Long, List<Integer>> userConstruct = new HashMap<>();
		userConstruct = userService.getValidUserEntries();
		int count = 0;
		
		for(Entry<Long, List<Integer>> mapEntry : userConstruct.entrySet()) {
			
			Long userId = mapEntry.getKey();
			List<Integer> userSelection = mapEntry.getValue();
			
			int[] specificUserPreference = convertIntegerListToArray(7, userSelection);
			
			int id = Math.toIntExact(userId);
			
			specificUserPreference[0] = id;
			//problem!!!! - fix tomorrow
			allUserPreferences[count] = specificUserPreference;
			
			count++;
		}
		return allUserPreferences;
	}
	
		
	
	public long[] convertLongListToArray(int arrayLength, List<Long> list) {
		
		long[] arrayForm = new long[arrayLength];
				
		if(arrayLength == 7) {
			
			for(int i = 0; i < list.size(); i++) {
				
				arrayForm[i + 1] = list.get(i);	
			}
			return arrayForm;
		}
		
		for(int i = 0; i < list.size(); i++) {
				
			arrayForm[i] = list.get(i);	
		}
		return arrayForm;		
	}
	
	 
	protected List<Long> convertSetToList(Set<Long> set) {
		
		List<Long> list = new ArrayList<>();
		
		for(Long number : set) {
			
			list.add(number);
		}
		return list;
	}
	
	public List<Long> validUserIds() {
		
		HashMap<Long, List<Integer>> userConstruct = new HashMap<>();
		
		userConstruct = userService.getValidUserEntries();
		
		Set<Long> ids = userConstruct.keySet();
		
		return convertSetToList(ids);
	}
	
	
	

}
