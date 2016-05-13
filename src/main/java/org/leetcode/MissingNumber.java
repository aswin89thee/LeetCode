package org.leetcode;

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?
 */
public class MissingNumber
{

	//Accepted solution with 1 ms runtime
    public int missingNumber(int[] nums)
    {
    	if(nums == null || nums.length == 0)
    		return 0;
    	long biggest = nums.length;
    	long sum = 0;
    	for(int i = 0 ; i < nums.length ; i++)
    	{
    		sum += nums[i];
    	}
    	//Using the formula summation up to N = N*(N+1)/2
    	//Calculate the sum of all elements, and subtract it from this formula to get the missing element
    	long half = biggest % 2 == 0 ? biggest/2 : (biggest+1)/2;
    	long odd = biggest % 2 == 0 ? biggest + 1 : biggest;
    	long prod = odd * half;
        return (int)(prod - sum);
    }
    
	public static void main(String[] args)
	{
		MissingNumber obj = new MissingNumber();
		int[] nums = {0,1};
		System.out.println(obj.missingNumber(nums));
	}

}
