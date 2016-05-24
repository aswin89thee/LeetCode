package org.leetcode;

public class PowerOfThree
{
	
	//Accepted solution with 19 ms runtime
	//Interestingly, using natural logarithm here results in some roundoff error causing a test case to fail
	public boolean isPowerOfThree(int n)
	{
		return (Math.log10(n)/Math.log10(3)) % 1 == 0;
	}

	//Accepted solution with 21 ms runtime. Simple solution
	public boolean isPowerOfThree2(int n)
	{
        if(n <=0 )
            return false;
        while(n > 1)
        {
            if(n % 3 != 0)
            	return false;
            n = n / 3;
        }
        return n == 1;
    }
	
	public static void main(String[] args)
	{
	}

}
