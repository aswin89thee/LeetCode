package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PascalTriangleII {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Integer> getRow(int rowIndex) {
        int[] a = new int[rowIndex+1];
        a[0] = 1;
        int i,j;
        if(rowIndex > 1){
        	for(i=0; i< rowIndex; i++){
        		for(j=i+1; j>0 ;j--){
        			a[j] += a[j-1];
        		}
        	}
        }
        
        return new ArrayList(Arrays.asList(a));
    }

	public static void main(String[] args) {
		PascalTriangleII obj = new PascalTriangleII();
		obj.getRow(0);
	}

}
