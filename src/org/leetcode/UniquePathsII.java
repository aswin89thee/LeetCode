package org.leetcode;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length==0) return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] paths = new int[m][n];
		for( int i = 0; i < m ; i++){
			for (int j = 0 ; j < n ; j++)
				paths[i][j] = -1;
		}
		return nPaths(obstacleGrid,0,0,paths);
    }
	private int nPaths(int[][] obstacleGrid, int a, int b,int[][] paths) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(a>=m) return 0;
		if(b>=n) return 0;
		if(obstacleGrid[a][b] == 1){
			paths[a][b] = 0;
			return 0;
		}
		if(a==m-1 && b==n-1) return 1;
		if(paths[a][b] > -1)
			return paths[a][b];
		int rightPaths = nPaths(obstacleGrid, a,b+1,paths);
		int downPaths = nPaths(obstacleGrid, a+1,b,paths);
		paths[a][b] = rightPaths + downPaths;
		return rightPaths+downPaths;
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = {
				{0,0}
				};
		UniquePathsII obj = new UniquePathsII();
		System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
	}

}
