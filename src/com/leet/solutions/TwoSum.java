package com.leet.solutions;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
	
	//	Given an array of integers nums and an integer target, 
	//	return indices of the two numbers such that they add up to target.
		
	//	You may assume that each input would have exactly one solution, 
	//	and you may not use the same element twice.
	//
	//	You can return the answer in any order.
	
	// Pseudo -----------------------------------------------------------
	
	// initial pseudocode:
	// loop through nums
	// for each val, calculate the other num needed to add to get target
	// then look for that other num in the rest of the array 
	// if found, record the indices (of first val and second val)
	// if not found, continue looping
	
	// what helped create the correct solution (equation):
	// equation: i + j = t
	// i is any given int, j is what is needed to add to i to get t, which is target
	// given i, then look for j -> j = t - i

    
    public int[] calculateSolutionBruteForce(int[] nums, int target) {
    	
    	int[] solution = new int[2];
    	
    	for (int i = 0; i < nums.length; i++) {
			int secondValue = target - nums[i];
    		for (int j = i+1; j < nums.length; j++) {
    			if (nums[j] == secondValue) {
    				solution[0] = i;
    				solution[1] = j;
    			} 
    		}
    	}
    	return solution; 	
    }
    
    public int[] calculateSolutionTwoPassHashTable(int[] nums, int target) {
    	
    	int[] solution = new int[2];
    	
    	Map<Integer,Integer> map = new HashMap<>();
    	// need loop to load array vals into a map with indices (key,val)
    	// the array value is the key, index is the value
    	for(int i = 0; i < nums.length; i++) {
    		map.put(nums[i], i);
    	}
    	// calculate the second "complement" value
    	// then check the map for that key
    	// if found, get its value (the index)
    	for(int i = 0; i < nums.length; i++) {
    		int secondValue = target - nums[i];
    		// look in the map which is near constant time
    		// make sure to exclude itself (since in equation i + j = t, i cannot equal j, and there are no dups in the input)
    		if (map.containsKey(secondValue) && map.get(secondValue) != i) {
    			solution[0] = i; // index of first value
    			solution[1] = map.get(secondValue); // index of 2nd value (from map)
    		}
    	}
    	
    	// this solution trades space (for the hash table) for better speed (runtime complexity)
    	// checking for that 2nd value was faster using this hashmap lookup
    	return solution; 	
    }
    
    public static void main(String[] args) {
    	
    	TwoSum twoSum = new TwoSum() ;
 
    	int[] solution = twoSum.calculateSolutionBruteForce(new int[] {2,7,11,15}, 9);
    	System.out.println("[" + solution[0] + "," + solution[1] + "]");
    	System.out.println("End of first solution");
    	
    	solution = twoSum.calculateSolutionBruteForce(new int[] {3,2,4}, 6);
    	System.out.println("[" + solution[0] + "," + solution[1] + "]");
    	System.out.println("End of second solution");
    	
    	solution = twoSum.calculateSolutionBruteForce(new int[] {3,3}, 6);
    	System.out.println("[" + solution[0] + "," + solution[1] + "]");
    	System.out.println("End of third solution");
    	
    	solution = twoSum.calculateSolutionBruteForce(new int[] {-1,-2,-3,-4,-5}, -8);
    	System.out.println("[" + solution[0] + "," + solution[1] + "]");
    	System.out.println("End of fourth solution");
    	
    	solution = twoSum.calculateSolutionTwoPassHashTable(new int[] {2,7,11,15}, 9);
    	System.out.println("[" + solution[0] + "," + solution[1] + "]");
    	System.out.println("End of two pass hash table solution");
		
	}
}
