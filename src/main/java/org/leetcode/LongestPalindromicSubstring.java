package org.leetcode;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring
{
	//Accepted solution from programcreek.com (107 ms runtime)
	//Although, this solution is the same as my dynamic programming solution from below (longestPalindrome2)
	//Not sure why mine had time limit exceeded
	public String longestPalindrome(String s) {
	    if(s==null || s.length()<=1)
	        return s;
	 
	    int len = s.length();
	    int maxLen = 1;
	    boolean [][] dp = new boolean[len][len];
	 
	    String longest = null;
	    for(int l=0; l<s.length(); l++){
	        for(int i=0; i<len-l; i++){
	            int j = i+l;
	            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
	                dp[i][j]=true;
	 
	                if(j-i+1>maxLen){
	                   maxLen = j-i+1; 
	                   longest = s.substring(i, j+1);
	                }
	            }
	        }
	    }
	 
	    return longest;
	}
	
	//Dynamic programming solution. Still time limit exceeded
	public String longestPalindrome2(String s)
	{
		if(s == null || s.length() <= 1)
			return s;
		int len = s.length();
		int[][] pals = new int[len][len];
		int palStart = 0, palEnd = 0;
		int longestPalLength = 0;
		char[] arr = s.toCharArray();
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
				if(arr[k] != arr[j] || (j+1 < k-1 && pals[j+1][k - 1] != 1))
					continue;
				pals[j][k] = 1;
				if(k - j + 1 > longestPalLength)
				{
					longestPalLength = k+1-j;
					palStart = j;
					palEnd = k+1;
				}
			}
		}
		return s.substring(palStart, palEnd);
	}
	
	
	//O(n^2) runtime and O(1) space solution. Time limit exceeded
	public String longestPalindrome3(String s)
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
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		long start = System.currentTimeMillis();
		String longestPal = obj.longestPalindrome(str);
		long end = System.currentTimeMillis();
		System.out.println("Longest palindrome is " + longestPal);
		System.out.println("Length of longest palindrome : " + longestPal.length());
		System.out.println("Time to compute longest palindrome : " + (end-start) + " ms");
	}

}
