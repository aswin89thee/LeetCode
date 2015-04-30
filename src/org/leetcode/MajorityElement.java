package org.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MajorityElement {
	public int majorityElement(int[] nums) {
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
		int[] a = {2,3,4,4,5,4,6,2,2,2};
		System.out.println("Majority element is " + obj.majorityElement(a));
	}
}
