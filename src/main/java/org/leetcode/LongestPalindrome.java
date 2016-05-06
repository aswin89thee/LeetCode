package org.leetcode;

public class LongestPalindrome
{
	
	//Dynamic programming solution. Still time limit exceeded
	public String longestPalindrome(String s)
	{
		if(s == null || s.length() <= 1)
			return s;
		String longestPal = "";
		int len = s.length();
		int[][] pals = new int[len][len];
		for(int i = 0 ; i < len ; i++)
		{
			for(int j = 0 ; i+j < len ; j++)
			{
				int k = i+j;
				if(k == j)
				{
					pals[j][k] = 1;
					continue;
				}
				if(s.charAt(k) != s.charAt(j) || (j+1 < k-1 && pals[j+1][k - 1] != 1))
					continue;
				pals[j][k] = 1;
				if(k - j + 1 > longestPal.length())
					longestPal = s.substring(j,k+1);
			}
		}
		return longestPal;
	}
	
	
	//O(n^2) runtime and O(1) space solution. Time limit exceeded
	public String longestPalindrome2(String s)
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

	public static void main(String[] args)
	{
		LongestPalindrome obj = new LongestPalindrome();
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		long start = System.currentTimeMillis();
		String longestPal = obj.longestPalindrome(str);
		long end = System.currentTimeMillis();
		System.out.println("Longest palindrome is " + longestPal);
		System.out.println("Length of longest palindrome : " + longestPal.length());
		System.out.println("Time to compute longest palindrome : " + (end-start) + " ms");
	}

}
