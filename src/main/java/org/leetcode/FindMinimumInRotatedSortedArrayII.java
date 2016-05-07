package org.leetcode;

/*
 * Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII
{
	//Accepted solution with 1 ms runtime
	public int findMin(int[] nums)
	{
		return this.findMinInRange(nums, 0, nums.length - 1);
	}
	public int findMinInRange(int[] nums, int lo ,int hi)
	{
		if(nums[lo] < nums[hi])
			return nums[lo];
		while(lo < hi-1)
		{
			int mid = lo + (hi - lo)/2;
			if(nums[lo] == nums[mid])
				return Integer.min(this.findMinInRange(nums, lo, mid), this.findMinInRange(nums, mid, hi));
			if(nums[lo] < nums[mid])
				lo = mid;
			else
				hi = mid;
		}
		return Integer.min(nums[lo], nums[hi]);
    }

	public static void main(String[] args)
	{
		FindMinimumInRotatedSortedArrayII obj = new FindMinimumInRotatedSortedArrayII();
		int[] nums = {10,1,10,10,10};
		System.out.println(obj.findMin(nums));
	}

}
