package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
		int[] ret = new int[2];
		if(nums == null || nums.length == 0) return ret;
		for(int i = 0 ; i < nums.length ; i++){
			int cur = nums[i];
			if(indexMap.get(target-cur) != null){
				int otherIndex = indexMap.get(target-cur);
				ret[0] = i < otherIndex ? i+1 : otherIndex+1;
				ret[1] = i > otherIndex ? i+1 : otherIndex+1;
				return ret;
			}else{
				indexMap.put(cur, i);
			}
		}
        
		return ret;
    }
	public static void main(String[] args) {
		TwoSum obj = new TwoSum();
		int[] nums = {2,7};
		int[] ret = obj.twoSum(nums, 9);
		for(int cur : ret){
			System.out.print(cur + " ");
		}
	}

}
