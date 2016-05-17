package org.leetcode;

/*
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOfOneBits
{

	//Accepted solution with 2 ms runtime
    // you need to treat n as an unsigned value
    public int hammingWeight(int n)
    {
    	int count = 0;
    	for(int i = 0 ; i < 32 ; i++)
    	{
    		if(((n >> i) & 1) == 1)
    			++count;
    	}
        return count;
    }
    
	public static void main(String[] args)
	{
		NumberOfOneBits obj = new NumberOfOneBits();
		System.out.println(obj.hammingWeight(11));
	}

}
