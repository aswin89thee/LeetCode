package org.leetcode;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGame
{

	//Accepted solution with 2 ms runtime
	//Simple solution - start checking from the right. 
	//Keep track of the last position from which you are able to reach the end 
	//Check if the current value is greater than the distance to the last reachable position
	public boolean canJump(int[] nums)
	{
		if(nums.length <= 1)
			return true;
		int len = nums.length;
		boolean[] jumpable = new boolean[len];
		jumpable[len-1] = true;
		int lastTrueIndex = len - 1;
		for(int i = len - 2; i >= 0 ; i--)
		{
			if(nums[i] == 0)
			{
				jumpable[i] = false;
				continue;
			}
			if(nums[i] >= lastTrueIndex - i)
			{
				jumpable[i] = true;
				lastTrueIndex = i;
			}
		}
		return jumpable[0];
	}

	public static void main(String[] args)
	{
		JumpGame obj = new JumpGame();
		int[] nums = {3,2,1,0,4};
		System.out.println(obj.canJump(nums));
	}

}
