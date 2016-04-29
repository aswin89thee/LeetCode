package org.leetcode;

public class SingleNumber {
	public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
        	int cur = nums[i];
        	sum = sum ^ cur;
        }
        return sum;
    }
	public static void main(String[] args) {
		SingleNumber obj = new SingleNumber();
		int[] a = {1,1,2,3,2,4,4};
		int res = obj.singleNumber(a);
		System.out.println(res);
	}

}
