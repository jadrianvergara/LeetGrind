package com.leet.solutions;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] input1 = {1,1,2};
		int[] input2 = {0,0,1,1,1,2,2,3,3,4};
		
		RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
		// r.removeDuplicates(input1);
		r.removeDuplicates(input2);

	}
	
    public int removeDuplicates(int[] nums) {
        // Check if the array is empty or has one element
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        // Initialize j to 0 to track the next position for a unique element
        int j = 0;

        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is not equal to the previous one,
            // it's a unique element. Copy it to nums[j + 1].
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        // The number of unique elements is j + 1
        System.out.println(Arrays.toString(nums));
        return j + 1;
    }

}
