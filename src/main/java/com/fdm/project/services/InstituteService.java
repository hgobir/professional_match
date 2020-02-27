package com.fdm.project.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fdm.project.logic.UserPreferenceArrayTransformer;
import com.fdm.project.models.Institute;
import com.fdm.project.repositories.InstituteRepository;


@Component
@Service
public class InstituteService {
	
	
	@Autowired
	private InstituteRepository instituteRepository;
	
	@Autowired
	private UserPreferenceArrayTransformer userPreferenceArrayTransformer;
	
	
	public HashMap<Long, List<Integer>> getValidInstituteEntries() {
		
		HashMap<Long, List<Integer>> validInstitutePreferences = new HashMap<Long, List<Integer>>();
		
		List<Institute> validInstitutes = new ArrayList<Institute>();
		
		while(validInstitutes.size() != 5) {
			
			List<Institute> allInstitutes = instituteRepository.findAll();
			
			for(Institute institute: allInstitutes) {
				
				List<Integer> confirmedPreferences = randomiseInstitutePreferences();
				
				validInstitutePreferences.put(institute.getId(), confirmedPreferences);
			}
			break;
		}
		return validInstitutePreferences;
	}


	private List<Integer> randomiseInstitutePreferences() {
		
		List<Long> userIds = userPreferenceArrayTransformer.validUserIds();
		
		long[] userIdsAsArray = userPreferenceArrayTransformer.convertLongListToArray(5, userIds);
		
		List<Integer> institutePreference = new ArrayList<>();

		
		while(institutePreference.size() != 5) {
		
			Random r = new Random();
			int random = r.nextInt(5 - 0);
			
			long value = userIdsAsArray[random];
			
			Integer instituteChoice = Math.toIntExact(value);

			if(!institutePreference.contains(instituteChoice)) {
				
				
				institutePreference.add(instituteChoice);
				
			}
			
			
		}	
		return institutePreference;
	}

}
