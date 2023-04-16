
public class Palindrome {
	
	public boolean isPalindromeAsString(int x) {
		
		// take int, true if palindrome, false otherwise
		
		// convert int to string so we can loop it
		String intAsString = Integer.toString(x);
		System.out.println("input: "+ intAsString);
		
		// for it to be palindrome:
		// for given x, its complement must be equal
		// 121 - 0,1,2 -> 0 == 2
		// 112211 - 0, 1, 2, 3, 4, 5; 0 == 5, 1 == 4, 2 == 3
		// final index = length - 1
		// x,y are values, indices are i,complementIndex
		// index (x) + index (y) = final index
		// i + complementIndex = final index
		// complementIndex = finalIndex - i

		// calculate finalIndex first (static value)
		// for each index, we need to calculate the complement's index
		// complementIndex: index (y) = final index - index (x)
		// cI = fI - i
		// then check the complement's val
		// if val is NOT equal to complement's val, then fail out, return false
		// else it continues and returns true
		
		int finalIndex = intAsString.length()-1;
		
		for (int i = 0; i < intAsString.length(); i++) {
			int complementIndex = finalIndex -  i;	
			if (intAsString.charAt(i) != intAsString.charAt(complementIndex)) {
				return false;
			}
		}
		return true;
	}
	
	// the solution below was worse with runtime and memory compared to isPalindromeAsString()
	public boolean isPalindromeJustReverseString(int x) {
		
		String originalIntString = Integer.toString(x);
		String newString = "";

		for (int j = originalIntString.length()-1; j >= 0; j--) {
			newString += Character.toString(originalIntString.charAt(j));
		}
		
		// using == below may or may not work; in my case, it didn't work
		// since Java checks if it's the same object in memory and will depend on
		// if Java decided to optimize the use of string literals (it didn't in my case
		// so the condition actually failed despite equal contents);
		
		// to check the actual values, use the .equals() method as below	
		return originalIntString.equals(newString);
	}
	
	
	public static void main(String[] args) {
		
		Palindrome pal = new Palindrome();
		System.out.println("isPalindrome: " + pal.isPalindromeAsString(121));
		System.out.println("isPalindrome: " + pal.isPalindromeAsString(-121));
		System.out.println("isPalindrome: " + pal.isPalindromeAsString(10));
		
		System.out.println("isPalindrome: " + pal.isPalindromeJustReverseString(121));
		
	}

}
