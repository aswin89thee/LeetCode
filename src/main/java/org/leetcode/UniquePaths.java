package org.leetcode;

//Memoized version. For non-memoized version, build the array from the end : paths[m-1][n-1] down to paths[0][0]
public class UniquePaths {
	
	public int uniquePaths(int m, int n) {
		int[][] paths = new int[m][n];
        return nPaths(0,0,m,n,paths);
    }

	private int nPaths(int a, int b, int m, int n, int[][] paths) {
		if(a==m-1 && b==n-1) return 1;
		if(a>=m) return 0;
		if(b>=n) return 0;
		if(paths[a][b]>0)
			return paths[a][b];
		int rightPaths = nPaths(a,b+1,m,n,paths);
		int downPaths = nPaths(a+1,b,m,n,paths);
		paths[a][b] = rightPaths + downPaths;
		return rightPaths+downPaths;
	}

	public static void main(String[] args) {
		UniquePaths obj = new UniquePaths();
		System.out.println(obj.uniquePaths(3,3));
	}

}
