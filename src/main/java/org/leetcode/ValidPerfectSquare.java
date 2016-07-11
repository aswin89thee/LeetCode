package org.leetcode;

/*
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Returns: True

Example 2:
Input: 14
Returns: False
 */
public class ValidPerfectSquare
{
	//Accepted solution with 0 ms runtime (?)
    public boolean isPerfectSquare(int num)
    {
        if(num < 0)
        	return false;
        int lo = 0;
        int hi = num/2 + 1;
        while(lo <= hi)
        {
        	long mid = (lo+hi)/2;
        	long sq = mid * mid;
        	if(sq == (long)num)
        		return true;
        	if(sq > num)
        		hi = (int)mid - 1;
        	else
        		lo = (int)mid + 1;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
    	ValidPerfectSquare obj = new ValidPerfectSquare();
    	System.out.println(obj.isPerfectSquare(16));
    	System.out.println(obj.isPerfectSquare(14));
    }
}
