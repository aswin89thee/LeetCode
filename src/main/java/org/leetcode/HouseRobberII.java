package org.leetcode;

/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery 
so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one.
 Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class HouseRobberII
{
	//Accepted solution with 1 ms runtime
	//DP solution.
	public int rob(int[] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		int[] maxFromZero = new int[nums.length];
		int[] maxFromOne = new int[nums.length];
		maxFromOne[0] = 0;
		//Calculate max profit from robbing the first house
		for(int i = 0 ; i < nums.length ; i++)
		{
			int curHouseValue = nums[i];
        	curHouseValue = (i-2) >= 0 ? curHouseValue + maxFromZero[i-2] : curHouseValue;
        	int prevHouseValue = 0;
        	prevHouseValue = (i-1) >= 0 ? maxFromZero[i-1] : 0;
        	maxFromZero[i] = Integer.max(curHouseValue, prevHouseValue);
        	//Calculate for maxFromOne
        	if(i == 0)
        		continue;
        	curHouseValue = nums[i];
        	curHouseValue = (i - 2) >= 0 ? curHouseValue + maxFromOne[i-2] : curHouseValue;
        	prevHouseValue = (i - 1) >= 0 ? maxFromOne[i-1] : 0;
        	maxFromOne[i] = Integer.max(curHouseValue, prevHouseValue);
		}
		return Integer.max(maxFromZero[nums.length-2], maxFromOne[nums.length - 1]);
	}
	
	public static void main(String[] args)
	{
		HouseRobberII obj = new HouseRobberII();
		int[] nums = {1,3,2,5,3,7};
		System.out.println(obj.rob(nums));
	}

}
