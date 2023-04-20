package com.leet.solutions;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeralToInteger {
	
    public int romanToInt(String s) {
    	
    	// ** The goal is to convert a string (a valid roman numeral) to its integer representation **
    	
    	// loop thru string
    	
    	// start from the right
    	
    	// if value to the left is greater or equal to value checked, add value checked only and move 1
    	
    	// if value to the left is less, then subtract the value to the left from current value, add to total (starts at 0)
    	
    	// if nothing to the left of the value to compare, then just add that value to the total
    	
    	char[] charArray = s.toCharArray();
    	int total = 0;
    	Map<String,Integer> map = new HashMap<>();
    	map.put("I", 1);
    	map.put("V", 5);
    	map.put("X", 10);
    	map.put("L", 50);
    	map.put("C", 100);
    	map.put("D", 500);
    	map.put("M", 1000);
    	
    	for (int i = s.length()-1; i >= 0; i--) {
    		int valueBeingChecked = map.get(Character.toString(charArray[i]));
    		// make sure we don't check a value that's out of bounds
    		if (i == 0) {
    			total += valueBeingChecked;
    		} else {
        		int valueToTheLeft = map.get(Character.toString(charArray[i-1]));        		
        		if (valueToTheLeft >= valueBeingChecked) {
        			total += valueBeingChecked;
        		} else if (valueToTheLeft < valueBeingChecked) {
        			total += (valueBeingChecked - valueToTheLeft);
        			i--;
        		} 
    		}    		
    	}
    	return total;
    }

	public static void main(String[] args) {

		RomanNumeralToInteger roman = new RomanNumeralToInteger();
		System.out.println("input: " + "III");
		System.out.println("output: " + roman.romanToInt("III")); // 3
		System.out.println("------------");
		System.out.println("input: " + "LVIII");
		System.out.println("output: " + roman.romanToInt("LVIII")); // 58
		System.out.println("------------");
		System.out.println("input: " + "MCMXCIV");
		System.out.println("output: " + roman.romanToInt("MCMXCIV")); // 1994
		System.out.println("------------");
		System.out.println("input: " + "XXVII");
		System.out.println("output: " + roman.romanToInt("XXVII")); // 27
		System.out.println("------------");
		System.out.println("input: " + "MCMI");
		System.out.println("output: " + roman.romanToInt("MCMI")); // 1901
		
	}

}
