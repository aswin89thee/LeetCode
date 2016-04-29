package org.leetcode;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
		if(A.length <=1 ) return A.length;
		int pos = 0;
		for(int i = 1 ; i < A.length ; i++){
			if(A[i] != A[pos]){
				A[++pos] = A[i];
			}
		}
		return pos+1;
	}

	public static void main(String[] args) {
	}

}
