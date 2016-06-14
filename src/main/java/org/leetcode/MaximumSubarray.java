package org.leetcode;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray
{

	//Accepted solution with 1 ms runtime
	//The main logic here is that if we encounter an element which by itself is greater than its sum with running sum,
	//we reset the running sum and start adding from this element
    public int maxSubArray(int[] nums)
    {
    	if(nums == null || nums.length == 0)
    		return 0;
    	int maxSum = nums[0];
    	int runningSum = nums[0];
    	for(int i = 1 ; i < nums.length ; i++)
    	{
    		if(nums[i] + runningSum < nums[i])
    			runningSum = nums[i];
    		else
    			runningSum += nums[i];
    		maxSum = Integer.max(maxSum, runningSum);
    	}
        return maxSum;
    }
    
	public static void main(String[] args)
	{
		MaximumSubarray obj = new MaximumSubarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(obj.maxSubArray(nums));
	}

}
