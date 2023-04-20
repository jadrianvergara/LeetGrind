package com.leet.solutions;

public class LongestCommonPrefix {
	
    public String longestCommonPrefix(String[] strs) {
    	
        if (strs.length == 0 || strs == null) {
            return "";
        }
        
        // set first word to compare with
        String prefix = strs[0];
        
        // loop # of times for # of words in array, but start at 2nd element
        for (int i = 1; i < strs.length; i++) {
        	
        	// find the prefix in the string being processed
        	// if prefix is not in the word, keep subtracting a letter from the prefix UNTIL it is in the word
        	// then that is the new prefix and breaks out of while loop
        	// if it deletes enough characters where it cannot find the prefix in the word being processed, that means it's..
        	// .. impossible to match whole set, so there's no common prefix; return ""
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix solution = new LongestCommonPrefix();
		String[] input = {
				"flower",
				"flow",
				"flight"
		};
		String[] input2 = {
				"dog",
				"racecar",
				"car"
		};
		System.out.println("Longest prefix for input is " + solution.longestCommonPrefix(input));
		System.out.println("Longest prefix for input is " + solution.longestCommonPrefix(input2));
	}

}
