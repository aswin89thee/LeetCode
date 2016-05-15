package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares
{

	//Accepted solution with 761 ms runtime
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numSquares(int n)
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
	}

}
