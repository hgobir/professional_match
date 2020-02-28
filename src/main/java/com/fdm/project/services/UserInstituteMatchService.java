package com.fdm.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fdm.project.logic.InstitutePreferenceArrayTransformer;
import com.fdm.project.logic.StableMarriageAlgorithm;
import com.fdm.project.logic.UserPreferenceArrayTransformer;
import com.fdm.project.models.Institute;
import com.fdm.project.models.User;
import com.fdm.project.models.UserInstituteMatch;
import com.fdm.project.repositories.InstituteRepository;
import com.fdm.project.repositories.UserRepository;

@Component
@Service
public class UserInstituteMatchService {
	
	@Autowired
	private StableMarriageAlgorithm stableMarriageAlgorithm;
	
	@Autowired
	private UserPreferenceArrayTransformer uTransformer;

	@Autowired
	private InstitutePreferenceArrayTransformer iTransformer;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private InstituteRepository instituteRepository;
		
	
	public List<UserInstituteMatch> getAllMatches() {
		
		int[][] userPreferenceMatrix = uTransformer.processUsers();
		int[][] institutePreferenceMatrix = iTransformer.processInstitutes();
		
		Map<Integer, Integer> userInstituteMatch = stableMarriageAlgorithm.execute(userPreferenceMatrix, institutePreferenceMatrix);
		List<UserInstituteMatch> listOfMatches = new ArrayList<>();
		
		for(Entry<Integer, Integer> entry : userInstituteMatch.entrySet()) {
			
			Long userId = Long.valueOf(entry.getKey());
			
			User user = userRepository.getOne(userId);
			
			Long instituteId = Long.valueOf(entry.getValue());
			
			Institute institute = instituteRepository.getOne(instituteId);
			
			UserInstituteMatch match = new UserInstituteMatch(user, institute);
			
			listOfMatches.add(match);
		}		
		return listOfMatches;
	}


	public UserInstituteMatch getSingleMatch(long id) {
		
		int userId = Math.toIntExact(id);
		int[][] userPreferenceMatrix = uTransformer.processUsers();
		int[][] institutePreferenceMatrix = iTransformer.processInstitutes();
		
		Map<Integer, Integer> userInstituteMatch = stableMarriageAlgorithm.execute(userPreferenceMatrix, institutePreferenceMatrix);
		
		for(Entry<Integer, Integer> entry : userInstituteMatch.entrySet()) {
			
			if(entry.getKey() == userId) {
								
				User user = userRepository.getOne(id);
				
				Long instituteId = Long.valueOf(entry.getValue());
				
				Institute institute = instituteRepository.getOne(instituteId);
				
				UserInstituteMatch match = new UserInstituteMatch(user, institute);				
				return match;
			}			
		}		
		return null;
	}
	
	

}
