package com.fdm.project.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fdm.project.models.User;
import com.fdm.project.repositories.UserRepository;

@Component
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//move repo access methods to service
	
	public HashMap<Long, List<Integer>> getValidUserEntries() {
				
		HashMap<Long, List<Integer>> validUserPreferences = new HashMap<Long, List<Integer>>();
					
		List<User> allUsers = userRepository.findAll();
		List<Integer> userPreferences = new ArrayList<>();
		
		for(User user: allUsers) {
						
			userPreferences.add(user.getInstitute1());
			userPreferences.add(user.getInstitute2());
			userPreferences.add(user.getInstitute3());
			userPreferences.add(user.getInstitute4());
			userPreferences.add(user.getInstitute5());
			
			Set<Integer> set = new HashSet<Integer>(userPreferences);
			
			if(!set.contains(null) && set.size() == userPreferences.size()) {
				
				List<Integer> confirmedPreferences = new ArrayList<>();
				
				confirmedPreferences.add(user.getInstitute1());
				confirmedPreferences.add(user.getInstitute2());
				confirmedPreferences.add(user.getInstitute3());
				confirmedPreferences.add(user.getInstitute4());
				confirmedPreferences.add(user.getInstitute5());

				validUserPreferences.put(user.getId(), confirmedPreferences);
			}
			userPreferences.clear();
			
			if(validUserPreferences.size() == 5) {
				break;
			}
			continue;
		}
		return validUserPreferences;
	}
	
	
	
	
	

}
