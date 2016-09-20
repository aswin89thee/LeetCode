package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Credits:
Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.
 */
public class HappyNumber
{

	// Accepted solution with 4 ms runtime
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	public boolean isHappy(int n)
	{
        if(map.containsKey(n)) return false;
        map.put(n, 1);
        int sqSum = this.getSquareSumOfDigits(n);
        if(sqSum == 1)
        	return true;
        return isHappy(sqSum);
    }
	
	private int getSquareSumOfDigits(int n)
	{
		int sum = 0;
		while(n > 0)
		{
			int digit = n % 10;
			sum += digit * digit;
			n = n / 10;
		}
		return sum;
	}

	public static void main(String[] args)
	{
		HappyNumber obj = new HappyNumber();
		System.out.println(obj.isHappy(7));
	}

}
