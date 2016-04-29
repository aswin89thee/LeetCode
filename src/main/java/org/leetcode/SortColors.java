package org.leetcode;

public class SortColors {
	
	public void sortColors(int[] A) {
        if(A == null || A.length < 2) return;
        int zeroPointer = 0, twoPointer = A.length - 1;
        int i = 0;
        for(; i < A.length ; i++){
        	while(zeroPointer < A.length && A[zeroPointer] == 0) zeroPointer++;
        	while(twoPointer > 0 && A[twoPointer] == 2) twoPointer--;
        	if(twoPointer == 0 || zeroPointer == A.length-1) break;
        	if(i < zeroPointer) i = zeroPointer;
        	if(i > twoPointer) break;
        	if(A[i] == 2){
        		swap(A,i,twoPointer);
        		if(A[i] == 0){
        			swap(A,zeroPointer,i);
        		}
        	}else if(A[i] == 0){
        		swap(A,zeroPointer,i);
        		if(A[i] == 2){
        			swap(A,i,twoPointer);
        		}
        	}
        }
    }

	private void swap(int[] A, int a, int b) {
		A[a] = A[a] + A[b];
		A[b] = A[a] - A[b];
		A[a] = A[a] - A[b];
	}

	public static void main(String[] args) {
		SortColors obj = new SortColors();
		int[] A = {2,2};
		obj.sortColors(A);
		for(int num : A){
			System.out.print(num + " ");
		}
	}

}
