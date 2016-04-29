package org.leetcode;

public class HouseRobber {
	
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
        int[] maxVal = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
        	int val1 = nums[i];
        	val1 = (i-2) >= 0 ? val1+maxVal[i-2] : val1;
        	int val2 = 0;
        	val2 = (i-1) >= 0 ? maxVal[i-1] : 0;
        	maxVal[i] = val1 > val2 ? val1 : val2;
        }
        
        return maxVal[maxVal.length-1];
    }

	public static void main(String[] args) {
		int[] nums = {2,1};
		HouseRobber obj = new HouseRobber();
		System.out.println(obj.rob(nums));
	}

}
