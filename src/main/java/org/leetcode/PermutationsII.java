package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Not the best idea to recurse and fill up the stack, but leetcode accepted it eventually so :-)
//Initially with this solution, time limit had exceeded for a bigger array with many duplicates
//Was able to overcome that using a hashmap so that we can avoid computing the permutations for elements that we have already visited
public class PermutationsII {
	Map<Integer,Integer> seenMap = new HashMap<Integer,Integer>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		List<Integer> inputList = new ArrayList<Integer>();
		for( int cur : nums){
			inputList.add(cur);
		}
		List<Integer> curList = new ArrayList<Integer>();
		Set<List<Integer>> finalSet = new HashSet<List<Integer>>();
		doPermutations(inputList,curList,finalSet);
		finalList.addAll(finalSet);
		return finalList;
	}

	private void doPermutations(List<Integer> inputList, List<Integer> curList, Set<List<Integer>> finalList) {
		if(inputList.isEmpty() && !curList.isEmpty()){
			finalList.add(curList);
			return;
		}
		for(int i = 0 ; i < inputList.size() ; i++){
			int curVal = inputList.get(i);
			if(curList.isEmpty() && seenMap.get(curVal) != null){continue;}
			List<Integer> newList = new ArrayList<Integer>(inputList);
			newList.remove(new Integer(curVal));
			List<Integer> newCurList = new ArrayList<Integer>(curList);
			newCurList.add(curVal);
			doPermutations(newList,newCurList,finalList);
			if(curList.isEmpty() && seenMap.get(curVal) == null){
				seenMap.put(curVal, 1);
			}
		}
	}

	public static void main(String[] args) {
		PermutationsII obj = new PermutationsII();
		int[] a = {1,1,2};
		List<List<Integer>> permutedList = obj.permuteUnique(a);
		System.out.println(permutedList.toString());
	}

}
