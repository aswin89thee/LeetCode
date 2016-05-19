package org.leetcode;

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII
{

	//Accepted solution with 0 ms runtime (?)
	public int[][] generateMatrix(int n)
	{
		int[][] matrix = new int[n][n];
		if(n < 1)
			return matrix;
		int k = 1;
		int rowStart = 0, rowEnd = n - 1;
		int colStart = 0, colEnd = n - 1;
		final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
		int direction = RIGHT;
		int i = 0, j = 0;
		while(i >= rowStart && i <= rowEnd && j >= colStart && j <= colEnd)
		{
			matrix[i][j] = k;
			k++;
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
		return matrix;
	}

	public static void main(String[] args)
	{
		SpiralMatrixII obj = new SpiralMatrixII();
		int n = 3;
		int[][] matrix = obj.generateMatrix(n);
		for(int i = 0 ; i < n ; i++)
		{
			System.out.println();
			for(int j = 0 ; j < n ; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
		}
	}

}
