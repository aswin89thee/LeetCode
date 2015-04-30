package org.leetcode;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
		if(A == null || A.length == 0) return 0;
		int occurrences = 0;
		int last = A.length-1;
		while(last >= 0 && A[last] == elem){
			if(last < 0) break;
			A[last] = elem-1;
			occurrences++;
			last--;
		}
		if(last < 0) return (A.length - occurrences);
		for(int i = 0 ; i < A.length ; i++){
			if(last <= i){
				if(A[i] == elem && last >= 0) A[i] = A[last];
				break;
			}
			if(A[i] == elem){
				occurrences++;
				A[i] = A[last];
				last--;
				while(last >= 0 && A[last]==elem){
					if(last < 0) break;
					A[last] = elem-1;
					occurrences++;
					last--;
				}
			}
		}
		
		return (A.length - occurrences);
	}

	public static void main(String[] args) {
		RemoveElement obj = new RemoveElement();
//		int[] a = {1,2,3,2,2,1,4};
		int[]a = {1};
		int newLen = obj.removeElement(a, 1);
		System.out.println(newLen);
	}

}
