package com.fdm.project.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

@Component
public class StableMarriageAlgorithm {
	
	
	public Map<Integer, Integer> execute(int[][] userPreferences, int[][] institutePreferences) {

		Map<Integer, Integer> pairs = new HashMap<>();
		
		int previousUser = 0;
	    boolean stability = false;
	    int currentUser;
	    
	    while(!stability) {
	
	        //go through males
	        for(int i = 0; i < userPreferences.length; i++) {
	
	//          //0 indicates free 1 indicates married
	//after this has run once find way to go through only unmarried males
	//          //go through list of prefs for particular male
	            for(int j = 1; j < userPreferences[i].length - 1; j++) {
	
	                if (userPreferences[i][userPreferences[i].length - 1] == 0) {
	
	                    currentUser = userPreferences[i][0];
	//
	//                //identifies preferred option
	                    int preferredInstitute = userPreferences[i][j];
	
	                    //checks availability
	                    boolean freeInstitute = availabilityFlag(preferredInstitute, institutePreferences);
	                    //if female unmarried
	                    if (freeInstitute) {
	
	                        //new pairing added
	                    	
	                        pairs.put(currentUser, preferredInstitute);
	
	                        //current male now married
	                        userPreferences[i][userPreferences[i].length - 1] = 1;
	
	                        //current female now married
	                        toggleInstituteMatchInd(preferredInstitute, institutePreferences);
	
	                        break;
	                    //if female married
	                    } else {
	                    	
	                    	//get current married partner
	                    	for(Entry<Integer, Integer> entry : pairs.entrySet()) {
	                    		
	                    		if(entry.getValue() == preferredInstitute) {
	                    			previousUser = entry.getKey();
	                    		}
	                    	}	
	                        //true if paired male preferred over proposing male
	                        //false if proposing male preferred over paired male --- have a look at this method!
	                        boolean institutePreference = preferenceResolver(currentUser, previousUser, preferredInstitute, institutePreferences);
	
	                        //if female preferred proposing male
	                        if (!institutePreference) {
	
	                            //new pairing added
	                            pairs.put(currentUser,preferredInstitute);
	
	                            //current male now married
	                            userPreferences[i][userPreferences[i].length - 1] = 1;
	
	                            //previous male unmarried
	                            togglePreviousUserUnmatchedInd(previousUser, userPreferences);
	
	                            break;
	
	                        }
	                        //else do nothing!
	                    }
	                }
	            }
	        }
	        //check if all men married
	        stability = isMatchStable(userPreferences);
	    }
	    //check if output is correct
	    System.out.println(pairs.toString());
	    return pairs;
	}
	
	
	
	private boolean isMatchStable(int[][] userPreferences) {
	
	    for(int m = 0; m < userPreferences.length; m++) {
	        if(userPreferences[m][userPreferences[m].length - 1] == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	private void togglePreviousUserUnmatchedInd(int previousUser, int[][] malePreferences) {
	
	    for(int l = 0; l < malePreferences.length; l++) {
	
	        if(malePreferences[l][0] == previousUser) {
	
	            malePreferences[l][malePreferences[l].length - 1] = 0;
	        }
	    }
	}
	
	private boolean preferenceResolver(int currentUser, int previousUser, int preferredInstitute, int[][] institutePreferences) {
	
	    int old = 0;
	    int proposing = 0;
	
	    //go through particular females preference
	    for(int i = 0; i < institutePreferences.length; i++) {
	
	        for(int j = 1; j < institutePreferences[i].length - 1; j++ ) {
	
	            if(institutePreferences[i][0] == preferredInstitute) {
	
	                if(institutePreferences[i][j] == previousUser) {
	                    old = j;
	                }
	
	                if(institutePreferences[i][j] == currentUser) {
	                    proposing = j;
	                }
	            }
	        }
	    }
	    //if old pair preferred (higher in preference == lower in index) over proposing return true otherwise return false
	    return old < proposing;
	}
	
	private void toggleInstituteMatchInd(int preferredInstitute, int[][] institutePreferences) {
	
	    for(int i = 0; i < institutePreferences.length; i++) {
	
	        if(institutePreferences[i][0] == preferredInstitute && institutePreferences[i][institutePreferences[i].length - 1] == 0) {
	
	            institutePreferences[i][institutePreferences[i].length - 1] = 1;
	            break;
	        }
	    }
	}
	
	private boolean availabilityFlag(int preferredInstitute, int[][] institutionPreferences) {
	
	    //go through particular females preference
	    for(int i = 0; i < institutionPreferences.length; i++) {
	
	        if(institutionPreferences[i][0] == preferredInstitute) {
	
	            if(institutionPreferences[i][institutionPreferences[i].length - 1] == 0) {
	
	                return true;
	            }
	        }
	    }
	    return false;
	}

}
