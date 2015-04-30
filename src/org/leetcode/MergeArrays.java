package org.leetcode;

public class MergeArrays {
	public void merge(int A[], int m, int B[], int n) {
		int ap = m-1, bp = n-1;
		for(int i = m+n-1 ; i>=0 ; i--){
			if(ap < 0){
				A[i] = B[bp];
				bp--;
				continue;
			}
			if(bp < 0){
				break;
			}
			if(A[ap] > B[bp]){
				A[i] = A[ap];
				ap--;
			}else{
				A[i] = B[bp];
				bp--;
			}
		}
	}

	public static void main(String[] args) {
		MergeArrays obj = new MergeArrays();
		int a[] = {4,5,6,0,0,0};
		int b[] = {1,2,3};
		obj.merge(a, 3, b, 3);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
