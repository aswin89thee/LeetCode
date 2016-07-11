package org.leetcode;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII
{
	
	//Accepted solution with 43 ms runtime
	//O(n^2) solution based on dynamic programming
	public int minCut(String s)
    {
		if(s == null || s.isEmpty())
			return 0;
		int[] cuts = new int[s.length()];
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int i = 0 ; i < s.length() ; i++)
		{
			int min = i;
			for(int j = 0 ; j <= i ; j++)
			{
				if(s.charAt(i) == s.charAt(j) && (i-j < 2 || dp[j+1][i-1]))//is a palindrom
				{
					dp[j][i] = true;
					min = j == 0 ? 0 : Integer.min(min, cuts[j-1] + 1);
				}
			}
			cuts[i] = min;
		}
		return cuts[s.length()-1];
    }

	//DP-based solution with O(n^3) runtime (or n^4? yikes). Time limit exceeded on OJ
    public int minCut2(String s)
    {
        if(s == null || s.isEmpty() || isPalindrome(s))
        	return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0 ; i < len ; i++)
        {
        	for(int j = 0 ; (i+j) < len ; j++)
        	{
        		int k = i + j;
        		if(isPalindrome(s.substring(j, k+1)))
        		{
        			dp[j][k] = 0;
        			continue;
        		}
        		if(k == j+1)
        		{
        			dp[j][k] = 1;
        			continue;
        		}
        		int min = Integer.MAX_VALUE;
        		for(int l = j ; l < k ; l++)
        		{
        			int cur = 1 + dp[j][l] + dp[l+1][k];
        			min = Integer.min(min, cur);
        		}
        		dp[j][k] = min;
        	}
        }
        return dp[0][len-1];
    }
    
    private boolean isPalindrome(String str)
    {
    	if(str.length() < 2)
    		return true;
    	int start = 0;
    	int end = str.length() - 1;
    	char[] arr = str.toCharArray();
    	while(start < end)
    	{
    		if(arr[start] != arr[end])
    			return false;
    		start++;
    		end--;
    	}
    	return true;
    }
    
	public static void main(String[] args)
	{
		PalindromePartitioningII obj = new PalindromePartitioningII();
		System.out.println(obj.minCut("aab")); //1
//		System.out.println(obj.minCut("aabcac")); //2
//		System.out.println(obj.minCut("cbbbcc")); //1
//		System.out.println(obj.minCut("cdd")); //1
	}

}
