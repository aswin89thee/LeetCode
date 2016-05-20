package org.leetcode;

/*
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
 */
public class UglyNumberII
{
	
	//Accepted solution with 8 ms runtime
	//DP solution based on https://leetcode.com/discuss/52905/my-16ms-c-dp-solution-with-short-explanation
    public int nthUglyNumber(int n)
    {
    	if(n < 1)
    		return 0;
    	int[] uglies = new int[n];
    	uglies[0] = 1;
    	int twoIndex = 0;
    	int threeIndex = 0;
    	int fiveIndex = 0;
    	for(int i = 1 ; i < n ; i++)
    	{
    		uglies[i] = Math.min(uglies[twoIndex]*2, Math.min(uglies[threeIndex]*3, uglies[fiveIndex]*5));
    		if(uglies[i] == uglies[twoIndex]*2)
    			twoIndex++;
    		if(uglies[i] == uglies[threeIndex] * 3)
    			threeIndex++;
    		if(uglies[i] == uglies[fiveIndex] * 5)
    			fiveIndex++;
    	}
    	return uglies[n-1];
    }
    
	public static void main(String[] args)
	{
		UglyNumberII obj = new UglyNumberII();
		System.out.println(obj.nthUglyNumber(10));
	}

}
