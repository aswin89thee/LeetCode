package org.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Leetcode time limit exceeded for {3,3,0,0,2,3,2}
public class PermutationsII {
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
			List<Integer> newList = new ArrayList<Integer>(inputList);
			newList.remove(new Integer(curVal));
			List<Integer> newCurList = new ArrayList<Integer>(curList);
			newCurList.add(curVal);
			doPermutations(newList,newCurList,finalList);
		}
	}

	public static void main(String[] args) {
		PermutationsII obj = new PermutationsII();
		int[] a = {3,3,0,0,2,3,2};
		List<List<Integer>> permutedList = obj.permuteUnique(a);
		System.out.println(permutedList.toString());
	}

}
