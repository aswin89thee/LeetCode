package org.leetcode;

import java.util.Stack;

/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
 */
public class LargestRectangleInHistogram
{

	//Accepted solution with 37 ms runtime
	//Stack-based solution inspired from http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	public int largestRectangleArea(int[] heights)
	{
		if(heights == null || heights.length == 0)
			return 0;
		int max = 0;
		int n = heights.length;
		Stack<Integer> stack = new Stack<Integer>();
		max = Integer.max(max, heights[0]);
		int i = 0;
		for(i = 0 ; i < n ; i++)
		{
			if(stack.isEmpty())
			{
				stack.push(i);
				continue;
			}
			if(heights[i] > heights[stack.peek()])
			{
				stack.push(i);
			}
			else
			{
				while(!stack.isEmpty() && heights[stack.peek()] > heights[i])
				{
					int top = stack.pop();
					max = Integer.max(max, heights[top] * (stack.isEmpty() ? i : (i-stack.peek()-1)));
				}
				stack.push(i);
			}
		}
		while(!stack.isEmpty())
		{
			int top = stack.pop();
			max = Integer.max(max, heights[top] * (stack.isEmpty() ? i : (i - stack.peek()-1)));
		}
		return max;
	}

	//O(n^2) solution - Time Limit Exceeded
	//Logic - for any range [i,j], its area is the product of minimum in that range and (j-i+1)
	//Compute all n^2 possible areas and find their maximum
	public int largestRectangleArea2(int[] heights)
	{
		int max = 0;
		if(heights == null || heights.length == 0)
			return max;
		int n = heights.length;
		int mins[][] = new int[n][n];
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = i ; j < n ; j++)
			{
				if(i == j)
					mins[i][j] = heights[i];
				else
					mins[i][j] = Integer.min(mins[i][j-1], heights[j]);
				max = Integer.max(max, mins[i][j]*(j-i+1));
			}
		}
		return max;
	}

	public static void main(String[] args)
	{
		LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
//		int[] heights = {2,1,5,6,2,3};
//		int[] heights = {3,2,1,5,4};
//		int[] heights = {9,0};
//		int[] heights = {2,1,2};
		int[] heights = {4,2};
		System.out.println(obj.largestRectangleArea(heights));
	}

}
