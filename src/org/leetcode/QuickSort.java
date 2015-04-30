package org.leetcode;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort obj = new QuickSort();
		int[] a = {4,1,7,3,9,6};
		obj.quickSort(a,0,a.length);
		obj.insertionSort(a);
		for( int element : a){
			System.out.print(" " + element + " ");
		}
	}

	private void quickSort(int[] a, int lo, int hi) {
		if(lo < hi){
			int p = partition(a,lo,hi);
			quickSort(a, lo, p);
			quickSort(a, p+1, hi);
		}
	}
	
	private void insertionSort(int[] a){
		for(int i = 0 ; i < a.length ; i++){
			for(int j = i ; j-1>=0 && a[j-1] > a[j] ; j--){
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
			}
		}
	}

	private int partition(int[] a, int lo, int hi) {
		int pivot = hi-1;
		int mypos = lo;
		for(int i = lo ; i < hi ; i++){
			if(a[i] < a[pivot]){
				int temp = a[i];
				a[i] = a[mypos];
				a[mypos] = temp;
				mypos++;
			}
		}
		int temp = a[mypos];
		a[mypos] = a[pivot];
		a[pivot] = temp;
		return mypos;
	}

}
