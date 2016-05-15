package org.leetcode;

/*
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo
{
	//Accepted solution with 3 ms runtime
    public boolean isPowerOfTwo(int n)
    {
    	if(n < 1)
    		return false;
    	for(int i = 0 ; i < 32 ; i++)
    	{
    		long curPwr = (1 << i);
    		long mask = ~curPwr;
    		if((n & curPwr) == curPwr && (mask & n) == 0)
    			return true;
    	}
    	return false;
    }

	public static void main(String[] args)
	{
		PowerOfTwo obj = new PowerOfTwo();
		System.out.println(obj.isPowerOfTwo(32768));
		System.out.println(obj.isPowerOfTwo(4000));
	}

}
