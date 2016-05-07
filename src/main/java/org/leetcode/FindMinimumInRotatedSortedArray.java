package org.leetcode;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray
{
	public int findMin(int[] nums)
	{
		int lo = 0;
		int hi = nums.length-1;
		if(nums[lo] < nums[hi])
			return nums[lo];
		while(lo < hi-1)
		{
			int mid = lo + (hi - lo)/2;
			if(nums[lo] < nums[mid])
				lo = mid;
			else
				hi = mid;
		}
		return Integer.min(nums[lo], nums[hi]);
    }

	public static void main(String[] args)
	{
		FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
		int[] nums = {4,0,2,3};
		System.out.println(obj.findMin(nums));
	}

}
