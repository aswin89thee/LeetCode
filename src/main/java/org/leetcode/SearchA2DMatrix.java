package org.leetcode;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */
public class SearchA2DMatrix
{
	//Accepted solution. 1 ms runtime
    public boolean searchMatrix(int[][] matrix, int target)
    {
    	if(matrix == null)
    		return false;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int lo = 0;
    	int hi = m*n - 1;
    	while(lo < hi)
    	{
    		int mid = lo + (hi - lo)/2;
    		int val = getIndexedElementInMatrix(matrix, mid);
    		if(val== target)
    			return true;
    		if(val > target)
    			hi = mid - 1;
    		else
    			lo = mid + 1;
    	}
    	return getIndexedElementInMatrix(matrix, lo) == target;
    }
    
    private int getIndexedElementInMatrix(int[][] matrix, int ind)
    {
    	int n = matrix[0].length;
    	int i = ind/n;
    	int j = ind - n*i;
    	return matrix[i][j];
    }

	public static void main(String[] args)
	{
//		int[][] matrix = {
//		                  {1,   3,  5,  7},
//		                  {10, 11, 16, 20},
//		                  {23, 30, 34, 50}
//						 };
		int[][] matrix = {{1,3,5}};
		SearchA2DMatrix obj = new SearchA2DMatrix();
		System.out.println(obj.searchMatrix(matrix, 1));
	}

}
