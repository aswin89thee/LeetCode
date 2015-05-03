package org.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MajorityElement {
	//Using Moore's voting method. O(n) runtime with O(1) space
	public int majorityElement(int[] nums) {
        if(nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        int majElt = -1, majCnt = 0;;
        majElt = nums[0];
        majCnt = 1;
        int i = 0;
        for(i = 1 ; i < nums.length ; i++){
        	if(nums[i] == majElt){
        		majCnt++;
        		continue;
        	}else{
        		majCnt--;
        		if(majCnt == 0){
        			majElt = nums[i];
        			majCnt++;
        		}
        	}
        }
        //Since the problem statement says that a majority element always exists, we don't have to check if majElt occurs at least (n/2) times
        return majElt;
    }

	//Naive algorithm
	public int majorityElement2(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int cur : nums){
			if(map.containsKey(cur)){
				int val = map.get(cur);
				map.remove(cur);
				map.put(cur, val+1);
			}
			else{
				map.put(cur, 1);
			}
		}
		Set<Entry<Integer, Integer>> entries = map.entrySet();
		int maxVal = -1;
		int maxKey = -1;
		for(Entry<Integer, Integer> entry : entries){
			if(entry.getValue() > maxVal){
				maxVal = entry.getValue();
				maxKey = entry.getKey();
			}
		}
		return maxKey;
	}

	public static void main(String[] args){
		MajorityElement obj = new MajorityElement();
		int[] a =  {3,3,4,2,4,4,2,4,4};
		System.out.println("Majority element is " + obj.majorityElement(a));
	}
}
