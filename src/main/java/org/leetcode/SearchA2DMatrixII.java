package org.leetcode;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */
public class SearchA2DMatrixII
{
	//Accepted solution with 13 ms runtime
	//The bottom-left element and the top-right element are special
	//We can use them as a starting point to eliminate a row or column in each step
	//Here, I've used the bottom-left element as a starting point
	public boolean searchMatrix(int[][] matrix, int target)
	{
		if(matrix == null)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int row = m - 1;
		int col = 0;
		while(row >= 0 && col < n)
		{
			int val = matrix[row][col];
			if(val == target)
				return true;
			if(val > target)
				row--;
			else
				col++;
		}
		return false;
	}

	//Accepted solution with 76 ms runtime
	//I came up with this approach after overthinking it. This is a divide-and-conquer approach, but this is slower than above solution
	//This is slightly better than O(n^2) search, since it skips the first quadrant if the target is greater than the matrix[midrow][midcol]
	public boolean searchMatrix2(int[][] matrix, int target)
	{
		if(matrix == null)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int lorow = 0, locol = 0;
		int hirow = m-1, hicol = n-1;		
		return doMatrixBinSearch(matrix, target, lorow, locol, hirow, hicol);
	}

	//This Matrix binary search breaks the matrix into 4 quadrants, and performs search in each of them
	private boolean doMatrixBinSearch(int[][] matrix, int target, int lorow, int locol, int hirow, int hicol)
	{
		if(matrix[lorow][locol] == target || matrix[hirow][hicol] == target
				|| matrix[lorow][hicol] == target || matrix[hirow][locol] == target)
			return true;
		if(lorow >= hirow-1 && locol >= hicol-1)
		{
			return false;
		}
		int midrow = lorow + (hirow - lorow)/2;
		int midcol = locol + (hicol - locol)/2;
		if(matrix[midrow][midcol] == target)
			return true;
		if(matrix[midrow][midcol] > target && this.doMatrixBinSearch(matrix, target, lorow, locol, midrow, midcol))
			return true;
		if(this.doMatrixBinSearch(matrix, target, midrow, locol, hirow, midcol))
			return true;
		if(this.doMatrixBinSearch(matrix, target, lorow, midcol, midrow, hicol))
			return true;
		if(this.doMatrixBinSearch(matrix, target, midrow, midcol, hirow, hicol))
			return true;
		return false;
	}

	public static void main(String[] args)
	{
		SearchA2DMatrixII obj = new SearchA2DMatrixII();
		int[][] matrix = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		System.out.println(obj.searchMatrix(matrix, 16));
	}

}
