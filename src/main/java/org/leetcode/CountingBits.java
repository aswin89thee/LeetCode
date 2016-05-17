package org.leetcode;

/*
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation 
 * and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language
 */
public class CountingBits
{

	//Accepted solution with 3 ms runtime
	//DP solution
    public int[] countBits(int num)
    {
    	int[] ret = new int[num+1];
    	if(num == 0)
    		return ret;
    	ret[1] = 1;
    	if(num == 1)
    		return ret;
    	ret[2] = 1;
    	if(num == 2)
    		return ret;
    	int lastPowerOfTwo = 2;
    	for(int i = 3 ; i <= num ; i++)
    	{
    		if(i == lastPowerOfTwo * 2)
    		{
    			ret[i] = 1;
    			lastPowerOfTwo = i;
    			continue;
    		}
    		ret[i] = ret[lastPowerOfTwo] + ret[i - lastPowerOfTwo];
    	}
    	return ret;
    }
    
	public static void main(String[] args)
	{
		CountingBits obj = new CountingBits();
		int[] arr = obj.countBits(16);
		for(int i = 0 ; i < arr.length ; i++)
		{
			System.out.println(i + " : " + arr[i]);
		}
	}

}
