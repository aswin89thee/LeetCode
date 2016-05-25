package org.leetcode;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 */
public class JumpGameII
{
	//My failed attempt at a O(n) solution.
	public int jump(int[] nums)
	{
		if(nums == null || nums.length == 1)
			return 0;
		if(nums[0] >= nums.length - 1)
			return 1;
		int len = nums.length;
		int[] jumps = new int[len];
		jumps[len - 1] = 0;
		int lastBestIndex = len - 1;
		for(int i = len - 2 ; i >= 0 ; i--)
		{
			if(nums[i] == 0)
			{
				jumps[i] = Integer.MAX_VALUE;
				continue;
			}
			if(nums[i] >= (len-1 - i))
			{
				jumps[i] = 1;
				lastBestIndex = i;
				continue;
			}
			int jump1 = Integer.MAX_VALUE;
			if(nums[i+nums[i]] != 0)
				jump1 = 1 + jumps[i+nums[i]];
			
			int jump2 = Integer.MAX_VALUE;
			if(nums[i] >= lastBestIndex - i)
				jump2 = 1 + jumps[lastBestIndex];
			
			jumps[i] = Integer.min(jump1, jump2);
			
			if(jumps[i] < jumps[lastBestIndex])
				lastBestIndex = jumps[i];
		}
		return jumps[0];
	}
	
	//DP solution with O(n^2) runtime
	public int jump2(int[] nums)
	{
		if(nums == null || nums.length == 1)
			return 0;
		int len = nums.length;
		int[] jumps = new int[len];
		jumps[len - 1] = 0;
		for(int i = len - 2; i >= -0 ; i--)
		{
			if(nums[i] == 0)
			{
				jumps[i] = Integer.MAX_VALUE;
				continue;
			}
			int minJumps = Integer.MAX_VALUE;
			for(int j = i+1 ; j < len ; j++)
			{
				if(jumps[j] == Integer.MAX_VALUE || nums[i] < (j-i))
					continue;
				minJumps = Integer.min(minJumps, 1 + jumps[j]);
			}
			jumps[i] = minJumps;
		}
		return jumps[0];
	}

	//DP solution with O(n^3) runtime. Time limit exceeded when submitted.
	//This is me overthinking things after looking at "hard" difficulty on the page
    public int jump3(int[] nums)
    {
        if(nums == null || nums.length == 1)
        	return 0;
        int len = nums.length;
        int[][] jumps = new int[len][len];
        for(int i = 0 ; i < len ; i++)
        {
        	for(int j = 0 ; i+j < len ; j++)
        	{
        		int start = j, end = i+j;
        		if(start == end)
        			continue;
        		if(start == end - 1)
        		{
        			if(nums[start] >= 1)
        				jumps[start][end] = 1;
        			else
        				jumps[start][end] = 0;
        			continue;
        		}
        		if(nums[start] >= (end - start))
        		{
        			jumps[start][end] = 1;
        			continue;
        		}
        		int minJumps = Integer.MAX_VALUE;
        		for(int k = start + 1; k < end ; k++)
        		{
        			if(jumps[start][k] + jumps[k][end] < minJumps)
        				minJumps = jumps[start][k] + jumps[k][end];
        		}
        		jumps[start][end] = minJumps;
        	}
        }
        return jumps[0][len-1];
    }
    
	public static void main(String[] args)
	{
		JumpGameII obj = new JumpGameII();
		int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
		System.out.println(obj.jump(nums));
	}

}
