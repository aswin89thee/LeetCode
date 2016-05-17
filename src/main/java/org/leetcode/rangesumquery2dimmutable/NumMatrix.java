package org.leetcode.rangesumquery2dimmutable;

/*
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) 
 * and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class NumMatrix
{
	
	//Accepted solution with 8 ms runtime
	int[][] sumMatrix;
	
    public NumMatrix(int[][] matrix)
    {
        sumMatrix = new int[matrix.length][];
        constructSumMatrix(matrix);
    }

    private void constructSumMatrix(int[][] matrix)
    {
    	for(int i = 0 ; i < matrix.length ; i++)
    	{
    		sumMatrix[i] = new int[matrix[i].length];
    		sumMatrix[i][0] = matrix[i][0];
    		if(matrix[i].length < 2)
    			continue;
    		for(int j = 1 ; j < matrix[i].length ; j++)
    		{
    			sumMatrix[i][j] = sumMatrix[i][j-1] + matrix[i][j];
    		}
    	}
	}

	public int sumRegion(int row1, int col1, int row2, int col2)
    {
		int sum = 0;
		for(int i = row1 ; i <= row2 ; i++)
		{
			if(col1 == 0)
			{
				sum += sumMatrix[i][col2];
				continue;
			}
			sum += (sumMatrix[i][col2] - sumMatrix[i][col1-1]);
		}
        return sum;
    }
    
    public static void main(String[] args)
    {
    	int[][] matrix = {
    		  {3, 0, 1, 4, 2},
			  {5, 6, 3, 2, 1},
			  {1, 2, 0, 1, 5},
			  {4, 1, 0, 1, 7},
			  {1, 0, 3, 0, 5}
    	};
    	NumMatrix obj = new NumMatrix(matrix);
    	System.out.println(obj.sumRegion(1,2,2,4));
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);