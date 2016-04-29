package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Wrong answer
public class Subsets {

	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(S);
		if(S.length == 0) return null;
		for(int i = 0 ; i < S.length ; i++){
			for(int len = 1; len < S.length ; len++){
				for(int j = i ; j < S.length ; j++){
					List<Integer> curList = new ArrayList<Integer>();
					getSubsets(S,j,len,curList);
					list.add(curList);
				}
			}
		}
		return list;
	}

	private int getSubsets(int[] s, int j, int len, List<Integer> curList) {
		if(len > 1 && j == s.length-1) return -1;
		if(j >= s.length) return 0;
		if(len < 1) return 0;
		curList.add(s[j]);
		int ret = getSubsets(s,j+1,len-1,curList);
		if(ret == -1){
			curList.removeAll(curList);
		}
		return curList.size();
	}

	public static void main(String[] args) {
		Subsets obj = new Subsets();
		int[] S = {1,2,3};
		List<List<Integer>> list = obj.subsets(S);
		for(int i = 0 ; i < list.size() ; i++){
			for(int j = 0 ; j < list.get(i).size() ; j++){
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println("");
		}
	}

}
