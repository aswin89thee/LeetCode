package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size()==0) return 0;
		boolean[][] filled = new boolean[triangle.size()][triangle.size()];
		int[][] vals = new int[triangle.size()][triangle.size()];
        int minTot = findMinTotal(triangle,0,0,filled,vals);
        
        return minTot;
    }

	private int findMinTotal(List<List<Integer>> triangle,int index,int subIndex,boolean[][] filled, int[][] vals) {
		int minTot = 0;
		if(index == triangle.size()-1){
			if(subIndex < triangle.get(index).size()){
				return triangle.get(index).get(subIndex);
			}else{
				return Integer.MAX_VALUE;
			}
		}
		if(index >= triangle.size()) return 0;
		if(subIndex < 0 || subIndex >= triangle.get(index).size()) return Integer.MAX_VALUE;
		//Find the least of the paths below it
		if(filled[index][subIndex]){
			return vals[index][subIndex];
		}
		int curVal = triangle.get(index).get(subIndex);
		int downLeft = findMinTotal(triangle, index+1, subIndex,filled,vals);
		int downRight = findMinTotal(triangle, index+1, subIndex+1,filled,vals);
		minTot = curVal + Math.min(downLeft, downRight);
		filled[index][subIndex] = true;
		vals[index][subIndex] = minTot;
		return minTot;
	}

	public static void main(String[] args) {
		Triangle obj = new Triangle();
		List<Integer> list1 = new ArrayList<Integer>(); list1.add(2);
		List<Integer> list2 = new ArrayList<Integer>(); list2.add(3); list2.add(4);
		List<Integer> list3 = new ArrayList<Integer>(); list3.add(6); list3.add(5); list3.add(7);
		List<Integer> list4 = new ArrayList<Integer>(); list4.add(4); list4.add(1); list4.add(8); list4.add(3);
		List<List<Integer>> masterList = new ArrayList<List<Integer>>(); masterList.add(list1); masterList.add(list2); masterList.add(list3); masterList.add(list4);
		System.out.println(obj.minimumTotal(masterList));

	}

}
