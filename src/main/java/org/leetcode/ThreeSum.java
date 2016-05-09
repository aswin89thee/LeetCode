package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
	//Accepted solution with 9ms runtime
	//A better solution that is almost O(n^2), but avoids checking duplicates
	public List<List<Integer>> threeSum(int[] nums)
    {
		List<List<Integer>> masterList = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 3)
			return masterList;
		Arrays.sort(nums);
		for(int i = 0 ; i < nums.length - 1 ; i++)
		{
			if(i > 0 && nums[i] == nums[i-1])
				continue;
			int lo = i + 1;
			int hi = nums.length - 1;
			while(lo < hi)
			{
				if(nums[i] + nums[lo] + nums[hi] == 0)
				{
					List<Integer> curList = new ArrayList<Integer>();
					curList.add(nums[i]);
					curList.add(nums[lo]);
					curList.add(nums[hi]);
					masterList.add(curList);
					lo++;
					while(nums[lo] == nums[lo - 1] && lo < hi)
						lo++;
					hi--;
					while(nums[hi] == nums[hi+1] && lo < hi)
						hi--;
				}
				else if(nums[i] + nums[lo] + nums[hi] < 0)
					lo++;
				else if(nums[i] + nums[lo] + nums[hi] > 0)
					hi--;
			}
		}
		return masterList;
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
		int[] nums = {-1,0,1,2,-1,-4};
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
