package org.leetcode;

public class LongestPalindrome
{

	//O(n^2) runtime and O(1) space solution. Time limit exceeded
	public String longestPalindrome(String s)
	{
		if(s == null || s.isEmpty() || s.length() == 1)
			return s;
		String longestPal = "";
		for(int i = 0 ; i < s.length() ; i++)
		{
			String oddPal = getLongestPalindromeInRange(s, i, i);
			String longestPalAtI = oddPal;
			if(i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1))
			{
				String evenPal = getLongestPalindromeInRange(s, i, i + 1);
				longestPalAtI = evenPal.length() > oddPal.length() ? evenPal : oddPal;
			}
			longestPal = longestPalAtI.length() > longestPal.length() ? longestPalAtI : longestPal;
		}
		return longestPal;
	}
	
	private String getLongestPalindromeInRange(String s, int start, int end)
	{
		String longestPal = "";
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
		{
			longestPal = s.substring(start, end + 1);
			start--;
			end++;
		}
		return longestPal;
	}

	public static void main(String[] args) {
		LongestPalindrome obj = new LongestPalindrome();
		String str = "aaaa";
		System.out.println("Longest palindrome is " + obj.longestPalindrome(str));
	}

}
