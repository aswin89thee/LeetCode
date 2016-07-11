package org.leetcode;

/*
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width and height of one envelope is greater 
 * than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes
{

	//Accepted solution with 703 ms runtime (ugh)
	//This is my usual dp - Write the exponential function and simply plug the dp array in it. O(n^2) runtime
    public int maxEnvelopes(int[][] envelopes)
    {
        if(envelopes == null || envelopes.length == 0)
        	return 0;
        int maxFits = 1;
        int[] dp = new int[envelopes.length];
        for(int i = 0 ; i < envelopes.length ; i++)
        {
        	maxFits = Integer.max(maxFits, findMaxFit(envelopes, i, dp));
        }
        return maxFits;
    }
    
    private int findMaxFit(int[][] a, int i,int[] dp)
	{
    	if(dp[i] != 0) return dp[i];
    	int maxFits = 1;
    	for(int j = 0 ; j < a.length ; j++)
    	{
    		if(a[j][0] <= a[i][0] || a[j][1] <= a[i][1]) continue;
    		int curFit = 1 + findMaxFit(a,j, dp);
    		maxFits = Integer.max(maxFits, curFit);
    	}
    	dp[i] = maxFits;
		return maxFits;
	}

	public static void main(String[] args)
    {
    	RussianDollEnvelopes obj = new RussianDollEnvelopes();
    	int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
//    	int[][] envelopes = {{1,3},{2,4},{3,2},{6,5}, {5,7}};
    	System.out.println(obj.maxEnvelopes(envelopes));
    }
    
}
