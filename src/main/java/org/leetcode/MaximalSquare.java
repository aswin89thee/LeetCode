package org.leetcode;

import java.util.Arrays;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */
public class MaximalSquare
{
	//Accepted solution with 12 ms runtim
	//DP solution with O(m*n) runtime and O(m) space
	//Based on the optimized solution in 
	//https://discuss.leetcode.com/topic/15328/easy-dp-solution-in-c-with-detailed-explanations-8ms-o-n-2-time-and-o-n-space
	public int maximalSquare(char[][] matrix)
	{
		int max = 0;
		if(matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0 , j = 0;
		int[] prevCol = new int[m];
		int[] curCol = new int[m];
		//Initialize the first column array with the first column of the matrix
		for(i = 0 ; i < m ; i++)
		{
			prevCol[i] = matrix[i][0] - '0';
			max = Integer.max(max, prevCol[i]);
		}
		for(j = 1 ; j < n ; j++)
		{
			curCol[0] = matrix[0][j] - '0';
			max = Integer.max(max, curCol[0]);
			for(i = 1 ; i < m ; i++)
			{
				if(matrix[i][j] == '1')
				{
					curCol[i] = 1 + Integer.min(prevCol[i-1], Integer.min(prevCol[i], curCol[i-1]));
					max = Integer.max(max, curCol[i]);
				}
			}
			prevCol = curCol.clone();
			Arrays.fill(curCol, 0);
		}
		return max * max;
	}
	
	//Accepted solution with 14 ms runtime. Simple solution with O(m*n) space
    public int maximalSquare2(char[][] matrix)
    {
    	int max = 0;
    	if(matrix == null || matrix.length == 0)
    		return max;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[][] squareSize = new int[m][n];
    	int i = 0, j = 0;
    	for(i = 0 ; i < m ; i++)
    	{
    		for(j = 0 ; j < n ; j++)
    		{
    			if(matrix[i][j] == '0')
    				continue;
    			max = Integer.max(max, 1);
    			squareSize[i][j] = 1;
    			if(i-1 < 0 || j-1 < 0 || squareSize[i-1][j-1] < 1)
    				continue;    			
    			int sizeToCheck = squareSize[i-1][j-1];
    			//Check along the row and column
    			for(int k = 1 ; k <= sizeToCheck ; k++)
    			{
    				if(matrix[i-k][j] == '0' || matrix[i][j-k] == '0')
    					break;
    				else
    					squareSize[i][j]++;
    			}
    			max = Integer.max(max, squareSize[i][j]);
    		}
    	}
    	return max*max;
    }

	public static void main(String[] args)
	{
		MaximalSquare obj = new MaximalSquare();
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};// Expected answer : 4
		
//		char[][] matrix = {
//				"0001".toCharArray(),
//				"1101".toCharArray(),
//				"1111".toCharArray(),
//				"0111".toCharArray(),
//				"0111".toCharArray()
//		};//Expected answer : 9
		System.out.println(obj.maximalSquare(matrix));
	}

}
