package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        List<Integer> inputList = new ArrayList<Integer>();
        for( int cur : nums){
        	inputList.add(cur);
        }
        List<Integer> curList = new ArrayList<Integer>();
        doPermutations(inputList,curList,finalList);
        return finalList;
    }

	private void doPermutations(List<Integer> inputList, List<Integer> curList, List<List<Integer>> finalList) {
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
		Permutations obj = new Permutations();
		int[] a = {1,2,3};
		List<List<Integer>> permutedList = obj.permute(a);
		System.out.println(permutedList.toString());
	}

}
