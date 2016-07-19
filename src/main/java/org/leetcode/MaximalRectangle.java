package org.leetcode;

import java.util.Stack;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.


 */
public class MaximalRectangle
{

	//Accepted solution with 50 ms runtime
	//The solution based on the fact that this problem can be converted into a 2D version of
	//the problem "Largest Rectangle In Histogram"
	//For each element in each row, if it is 1, we first determine its "height" - the number of continuous ones 
	//starting from it and going up
	//Then for each row, we can simply do "Largest Rectangle In Histogram"
    public int maximalRectangle(char[][] matrix)
    {
    	if(matrix == null || matrix.length == 0)
    		return 0;
    	int max = 0;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int i = 0  , j = 0;
    	int heights[][] = new int[m][n];
    	//Update each element so that an element contains its "height" - the number of ones along its column from 0 to i
    	for(i = 0 ; i < m ; i++)
    		for(j = 0 ; j < n ; j++)
    		{
    			heights[i][j] = matrix[i][j] - '0';
    			if(i > 0 && heights[i][j] == 1)
    				heights[i][j] += heights[i-1][j];
    		}
    	//Use "Largest Rectangle In Histogram" algorithm for each row.
    	for(i = 0 ; i < m ; i++)
    	{
    		Stack<Integer> stack = new Stack<Integer>();
    		for(j = 0 ; j < n ; j++)
    		{
    			if(stack.isEmpty())
    			{
    				stack.push(j);
    				continue;
    			}
    			if(heights[i][j] > heights[i][stack.peek()])
    				stack.push(j);
    			else
    			{
    				while(!stack.isEmpty() && heights[i][stack.peek()] > heights[i][j])
    				{
    					int top = stack.pop();
    					max = Integer.max(max, heights[i][top] * (stack.isEmpty() ? j : (j-stack.peek()-1)));
    				}
    				stack.push(j);
    			}
    			
    		}
    		while(!stack.isEmpty())
			{
				int top = stack.pop();
				max = Integer.max(max, heights[i][top] * (stack.isEmpty() ? j : (j-stack.peek()-1)));
			}
    	}
    	return max;
    }
    
	public static void main(String[] args)
	{
		MaximalRectangle obj = new MaximalRectangle();
		char[][] matrix = {
				"10010".toCharArray(),
				"11111".toCharArray(),
				"10111".toCharArray(),
				"00000".toCharArray()
		};
		System.out.println(obj.maximalRectangle(matrix));
	}

}
