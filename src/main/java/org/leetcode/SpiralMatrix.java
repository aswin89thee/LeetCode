package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix
{

	//Accepted solution with 1 ms runtime
    public List<Integer> spiralOrder(int[][] matrix)
    {
    	List<Integer> list = new ArrayList<Integer>();
    	if(matrix.length == 0)
    		return list;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int rowStart = 0, rowEnd = m - 1;
    	int colStart = 0, colEnd = n - 1;
    	final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    	int direction = RIGHT;
    	int i = 0, j = 0;
    	while(i >= rowStart && i <= rowEnd && j >= colStart && j <= colEnd)
    	{
    		list.add(matrix[i][j]);
    		if(direction == UP)
    		{
    			if(i > rowStart)
    			{
    				i--;
    			}
    			else
    			{
    				direction = RIGHT;
    				j++;
    				colStart++;
    			}
    		}
    		else if (direction == DOWN)
    		{
    			if(i < rowEnd)
    			{
    				i++;
    			}
    			else
    			{
    				direction = LEFT;
    				j--;
    				colEnd--;
    			}
    		}
    		else if (direction == RIGHT)
    		{
    			if(j < colEnd)
    			{
    				j++;
    			}
    			else
    			{
    				direction = DOWN;
    				i++;
    				rowStart++;
    			}
    		}
    		else if (direction == LEFT)
    		{
    			if(j > colStart)
    			{
    				j--;
    			}
    			else
    			{
    				direction = UP;
    				i--;
    				rowEnd--;
    			}
    		}
    	}
        return list;
    }
    
	public static void main(String[] args)
	{
		SpiralMatrix obj = new SpiralMatrix();
		int[][] matrix = {{1,2,3},
						  {4,5,6},
						  {7,8,9}};
//		int[][] matrix = {{2,3}};
//		int[][] matrix = {{2,5,8},
//						  {4,0,-1}};
		List<Integer> list = obj.spiralOrder(matrix);
		for(Integer num : list)
			System.out.print(num + "  ");
	}

}
