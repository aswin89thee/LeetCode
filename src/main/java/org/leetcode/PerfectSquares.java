package org.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares
{
	//Accepted solution with 68 ms runtime
	//Dynamic Programming solution
	public int numSquares(int n)
    {
		if(n <= 3)
    		return n;
		int[] arr = new int[n+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0; arr[1] = 1; arr[2] = 2; arr[3] = 3;
		for(int i = 4; i <= n; i++)
		{
			for(int j = 1; j * j <= i ; j++)
			{
				arr[i] = Math.min(arr[i], 1+arr[i-j*j]);
			}
		}
		return arr[n];
    }

	//Accepted solution with 761 ms runtime
	//This is how I initially approach DP problems.
	//Write the recursive form, and then simply add a map to store the values at the end and retrieve at the beginning
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numSquares2(int n)
    {
    	if(n <= 3)
    		return n;
    	if(map.get(n) != null)
    		return map.get(n);
    	int sqrt = (int)Math.floor(Math.sqrt(n));
    	if(sqrt * sqrt == n)
    		return 1;
    	int smallestSquares = Integer.MAX_VALUE;
    	for(int i = sqrt ; i >= 1; i--)
    	{
    		int curVal = 1 + numSquares(n - (i * i));
    		if(curVal < smallestSquares)
    			smallestSquares = curVal;
    	}
    	map.put(n, smallestSquares);
        return smallestSquares;
    }
    
	public static void main(String[] args)
	{
		PerfectSquares obj = new PerfectSquares();
		System.out.println(obj.numSquares(12));
		System.out.println(obj.numSquares(13));
	}

}
