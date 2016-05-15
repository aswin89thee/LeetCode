package org.leetcode;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray
{

	//Accepted solution with 1 ms runtime
	public int search(int[] nums, int target)
	{
		int pos = -1;
		pos = binSearch(nums, 0, nums.length-1, target);
		return pos;
	}

	private int binSearch(int[] a, int lo, int hi, int target)
	{
		if(lo > hi) return -1;
		if(lo==hi)
		{
			if(a[lo]==target)
				return lo;
			else return -1;
		}
		int mid = (lo + hi)/2;
		boolean firstHalf = false;
		if(a[mid] > a[lo]) firstHalf = true;
		if(firstHalf)
		{
			int checkPos = binSearch(a,lo,mid,target);
			if( checkPos != -1)
			{
				return checkPos;
			}
			return binSearch(a,mid+1,hi,target);
		}else
		{
			int checkPos = binSearch(a,mid+1,hi,target);
			if( checkPos != -1)
			{
				return checkPos;
			}
			return binSearch(a,lo,mid,target);
		}
	}

	public static void main(String[] args)
	{
		int[] a = {4, 5, 6, 7, 0, 1, 2, 2};
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		System.out.println("Position of 2 is " + obj.search(a, 2));
	}

}
