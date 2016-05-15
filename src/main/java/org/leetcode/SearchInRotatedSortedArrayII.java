package org.leetcode;

/*
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedSortedArrayII
{
	
	//Accepted solution with 1 ms runtime
    public boolean search(int[] nums, int target)
    {
    	if(nums == null || nums.length == 0)
    		return false;
        return binSearch(nums, target, 0, nums.length - 1);
    }
	
	private boolean binSearch(int[] nums, int target, int lo, int hi)
	{
		if(lo >= hi)
		{
			if(lo >= 0 && lo < nums.length)
				return nums[lo] == target;
			if(hi >= 0 && hi < nums.length)
				return nums[hi] == target;
			return false;
		}
		while(lo < hi)
		{
			int mid = lo + (hi - lo)/2;
			if(nums[mid] == target || nums[lo] == target || nums[hi] == target)
				return true;
			if(nums[mid] > nums[lo])
			{
				if(nums[mid] > target && nums[lo] < target)
				{
					hi = mid - 1;
					continue;
				}
				else
				{
					lo = mid + 1;
					continue;
				}
			}
			else
			{
				return binSearch(nums, target, lo, mid - 1) || binSearch(nums, target, mid+1, hi);
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		SearchInRotatedSortedArrayII obj = new SearchInRotatedSortedArrayII();
		int[] nums = {1,1};
		System.out.println(obj.search(nums, 0));
	}

}
