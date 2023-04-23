package com.leet.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ValidParentheses {
	
    public boolean isValid(String s) {
        
    	int lengthofString = s.length();
    	
    	String[] openers = {"{", "[", "("};
    	String[] closers = {"}", "]", ")"};
    	
    	String openingHalf = "";
    	Map<Character,Character> mapOfOpenersToClosers = new HashMap<Character,Character>(){{
    		put('{','}');
    		put('[',']');
    		put('(',')');
    	}};
    	
    	boolean resetOpeningString = true;
    	if (lengthofString % 2 != 0 || Arrays.asList(closers).contains(s.charAt(0))) {
    		return false;
    	} else {
    		for (int i = 0; i <= s.length()-1;i++) {
    			if (Arrays.asList(openers).contains(Character.toString(s.charAt(i)))) {
    				if (resetOpeningString) {
    					openingHalf += s.charAt(i);
    				} else {
    					openingHalf = "";
    					openingHalf += s.charAt(i);
        				resetOpeningString = true;
    				}
    			} else {
    				StringBuilder reverseBuilder = new StringBuilder(openingHalf).reverse();
    				String reverse = reverseBuilder.toString();
    				
    				
    				// if closer, you HAVE to iterate # of times more equal to length of openingHalf because each opener needs closer
    				// otherwise, return false if you cannot even iterate that number of times
    				
    				int counter = 0;

    				while (counter < openingHalf.length()) {
    					char cccc = mapOfOpenersToClosers.get(reverse.charAt(counter));
    					char dddd = s.charAt(i);
    					
    					// {({[
    					// [{({})}]()
    					if(mapOfOpenersToClosers.get(reverse.charAt(counter)) != s.charAt(i) ) {
    						return false;
    					}
    					if (openingHalf.length() != 1) {
    	  					i++;
    					}
    					counter++;
  
    				}

//    				if (s.charAt(i) != mapOfOpenersToClosers.get(reverse.charAt(i-openingHalf.length()))) {
//    					return false;
//    				}
    				resetOpeningString = false;
    			}
    		}
    	}
    	return true;
    }

	public static void main(String[] args) {
		
		ValidParentheses solution = new ValidParentheses();
	
		System.out.println(solution.isValid("[]"));
		System.out.println(solution.isValid("[{({})}]()"));
		System.out.println(solution.isValid("()[]{}"));
		System.out.println(solution.isValid("()"));
		System.out.println(solution.isValid("["));
		System.out.println(solution.isValid("{}{]]"));
		System.out.println(solution.isValid("(]"));
	
		
		

	}

}
