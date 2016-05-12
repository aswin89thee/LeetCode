package org.leetcode;

/*
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.


 */
public class RotateArray
{
	//Accepted solution with 1 ms runtime
	//This is O(n) solution with O(1) extra space. Other solutions can include O(n^2) solution, or O(n) solution with O(k) extra space
    public void rotate(int[] nums, int k)
    {
        if(k == 0 || nums.length <= 1)
        	return;
        if(k > nums.length)
        	k = k % nums.length;
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length - k-1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end)
    {
    	while(start <= end)
    	{
    		//swap
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }
    
	public static void main(String[] args)
	{
		RotateArray obj = new RotateArray();
		int[] nums = {1,2,3,4,5,6};
		obj.rotate(nums, 11);
		System.out.println();
		for(Integer i : nums)
			System.out.print(i + ", ");
	}

}
