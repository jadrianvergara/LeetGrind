
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
	
	
	public static void main(String[] args) {
		
		Palindrome pal = new Palindrome();
		System.out.println("isPalindrome: " + pal.isPalindromeAsString(121));
		System.out.println("isPalindrome: " + pal.isPalindromeAsString(-121));
		System.out.println("isPalindrome: " + pal.isPalindromeAsString(10));
		
	}

}
