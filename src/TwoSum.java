
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
		
	}
}
