package org.leetcode;

public class JumpGame {
	//This solution works but for a really long input it causes a stack overflow
	//Check out the iterative version in haoel/leetcode for the right answer
	public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        boolean[] haveCalculated = new boolean[nums.length];
        boolean isJumpable = calculateJumpable(nums, 0, haveCalculated);
        return isJumpable;
    }

	private boolean calculateJumpable(int[] nums, int pos, boolean[] haveCalculated) {
		if(pos >= nums.length) return false;
		if(pos == nums.length - 1) return true;
		if(nums[pos] == 0){
			haveCalculated[pos] = true;
			return false;
		}
		if(haveCalculated[pos]) return false;
		int maxJumps = nums[pos];
		int i;
		for(i = 1 ; i <= maxJumps ; i++){
			boolean val = calculateJumpable(nums,pos+i,haveCalculated);
			if(val) return true;
			else{
				haveCalculated[pos+i] = true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		JumpGame obj = new JumpGame();
		int[] nums = {3,2,1,0,4};
		System.out.println(obj.canJump(nums));
	}

}
