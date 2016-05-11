package org.leetcode;

/*
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes
{

	//Accepted solution with 3 ms runtime
    public int trailingZeroes(int n)
    {
    	int zeros = 0;
    	int i = 1;
    	double fiveFactors = 1;
    	while(fiveFactors > 0)
    	{
    		long pow = (long) Math.pow(5, i);
    		fiveFactors = n / pow;
    		fiveFactors = Math.round(fiveFactors);
    		zeros += fiveFactors;
    		i++;
    	}
    	return zeros;
    }
    
	public static void main(String[] args)
	{
		FactorialTrailingZeroes obj = new FactorialTrailingZeroes();
		System.out.println(obj.trailingZeroes(2147483647));
	}

}
