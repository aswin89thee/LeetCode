package org.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */
public class ThreeSum
{
	public List<List<Integer>> threeSum(int[] nums)
    {
		return null;
    }
	
	//O(n^2) solution. Time limit exceeded
    public List<List<Integer>> threeSum2(int[] nums)
    {
    	Set<List<Integer>> masterList = new HashSet<List<Integer>>();
    	Map<Integer,Integer> intMap = new HashMap<Integer, Integer>();
    	for(int num : nums)
    	{
    		if(intMap.get(num) != null)
    			intMap.put(num, intMap.get(num) + 1);
    		else
    			intMap.put(num, 1);
    	}
    	for(int i = 0 ; i < nums.length; i++)
    	{
    		for(int j = 0 ; j < nums.length ; j++)
    		{
    			if(i == j)
    				continue;
    			int rem = - (nums[i] + nums[j]);
    			if(intMap.get(rem) != null)
    			{
    				if(rem == nums[i] || rem == nums[j])
    				{
    					if(intMap.get(rem) <= 1)
    						continue;
    				}
    				List<Integer> curList = new ArrayList<Integer>();
    				curList.add(nums[i]); curList.add(nums[j]); curList.add(rem);
    				Collections.sort(curList);
    				masterList.add(curList);
    			}
    		}
    	}
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	ret.addAll(masterList);
        return ret;
    }
    
	public static void main(String[] args)
	{
		ThreeSum obj = new ThreeSum();
//		int[] nums = {-1,0,1,2,-1,-4};
		int[] nums = {13,-5,3,3,-1,13,3,1,-9,-4,9,12,6,-9,-6,-12,-8,3,12,14,4,-15,2,-11,4,-12,10,9,-6,
				-3,-8,14,7,3,2,-8,-7,-10,8,-8,-7,-6,-11,6,-7,-2,9,-8,8,-2,13,-10,-2,0,-14,-13,-4,11,3,
				-3,-7,3,-4,8,13,13,-15,-9,10,0,-2,-12,1,2,9,1,8,-4,8,-7,9,7,-2,-15,14,0,-13,-13,-12,-2,
				-1,-11,8,10,12,6,8,4,12,3,11,-12,-2,-3,5,-15,6,-10,-4,-1,-1,-10,13};
		long startTime = System.currentTimeMillis();
		List<List<Integer>> list = obj.threeSum(nums);
		long endTime = System.currentTimeMillis();
		if(list != null)
		{
			for(List<Integer> curList : list)
				System.out.println(curList.toString());
		}
		
		System.out.println("Run time : " + (endTime - startTime) + " ms");
	}

}
