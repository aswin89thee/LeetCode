package org.leetcode;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray
{

	//Accepted solution with 4 ms runtime
	public int maxProduct(int[] nums)
    {
        if(nums == null || nums.length == 0)
        	return 0;
        int maxProd = nums[0];
        int max = nums[0], min = nums[0];
        int premax = nums[0], premin = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
        	if(nums[i] > 0)
        	{
        		max = Integer.max(nums[i], max * nums[i]);
        		min = Integer.min(nums[i], min * nums[i]);
        	}
        	else
        	{
            	premax = max; premin = min;
        		max = Integer.max(nums[i], premin * nums[i]);
        		min = Integer.min(nums[i], premax * nums[i]);
        	}
        	maxProd = Integer.max(max, maxProd);
        }
        return maxProd;
    }
    
	public static void main(String[] args)
	{
		MaximumProductSubarray obj = new MaximumProductSubarray();
		int[] nums = {2,3,-2,4};
		System.out.println(obj.maxProduct(nums));
	}

}
