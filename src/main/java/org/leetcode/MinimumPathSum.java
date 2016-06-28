package org.leetcode;

/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum
{
	
	//Accepted solution with 3 ms runtime (Dynamic Programming based solution)
    public int minPathSum(int[][] grid)
    {
        if(grid == null)
        	return 0;
        if(grid.length == 0)
        	return 0;
        Integer[][] minPathSums = new Integer[grid.length][grid[0].length];
        minPathSums[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];
        return getMinPathSum(grid, minPathSums, 0,0);
    }

	private int getMinPathSum(int[][] grid, Integer[][] minPathSums, int i, int j)
	{
		if(i == grid.length - 1 && j == grid[0].length-1)
			return grid[i][j];
		if(minPathSums[i][j] != null)
			return minPathSums[i][j];
		if(i == grid.length - 1)
		{
			int ret = grid[i][j] + getMinPathSum(grid, minPathSums, i , j+1);
			minPathSums[i][j] = ret;
			return ret;
		}
		if(j == grid[0].length - 1)
		{
			int ret = grid[i][j] + getMinPathSum(grid, minPathSums, i+1, j);
			minPathSums[i][j] = ret;
			return ret;
		}
		int ret = grid[i][j] + Integer.min(getMinPathSum(grid, minPathSums, i, j+1), getMinPathSum(grid, minPathSums, i+1, j));
		minPathSums[i][j] = ret;
		return ret;
	}

	public static void main(String[] args)
	{
		MinimumPathSum obj = new MinimumPathSum();
		int[][] grid = {
				{4,1,3,6},
				{5,7,2,4},
				{9,7,3,6}
		};
		System.out.println(obj.minPathSum(grid));
	}

}
