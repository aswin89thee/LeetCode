package org.leetcode;

public class SurroundedRegions {

	//Wrong algo.
	public void solve(char[][] board) {
		int i = 0, j = 0;
		for(i = 0 ; i < board.length ; i++){
			for(j = 0 ; j < board.length ; j++){
				if(i==1 && j==1)
					System.out.println("i="+i+"  j="+j);
				captureSurroundings(board,i,j);
			}
		}
	}

	private void captureSurroundings(char[][] board, int i, int j) {
		if(isCaptureable(board,i,j, -1, -1)){
			captureRegion(board,i,j);
		}
	}

	private boolean isCaptureable(char[][] board, int i, int j, int pi, int pj) {
		boolean leftCap = isLeftCaptureable(board,i,j,pi,pj);
		if(!leftCap) return false;
		boolean rightCap = isRightCaptureable(board,i,j,pi,pj);
		if(!rightCap) return false;
		boolean topCap = isTopCaptureable(board,i,j,pi,pj);
		if(!topCap) return false;
		boolean botCap = isBotCaptureable(board,i,j,pi,pj);
		if(!botCap) return false;
		boolean res = leftCap && rightCap && topCap && botCap;
		return res;
	}
	
	private boolean isBotCaptureable(char[][] board, int i, int j, int pi, int pj) {
		int checkI = i+1;
		int checkJ = j;
		if(checkI < 0 || checkI >= board.length) return false;
		if(checkJ < 0 || checkJ >= board.length) return false;
		if(board[checkI][checkJ] == 'X') return true;
		if(checkI == pi && checkJ == pj) return true;
		return isCaptureable(board,checkI,checkJ,i,j);
	}

	private boolean isTopCaptureable(char[][] board, int i, int j, int pi, int pj) {
		int checkI = i-1;
		int checkJ = j;
		if(checkI < 0 || checkI >= board.length) return false;
		if(checkJ < 0 || checkJ >= board.length) return false;
		if(board[checkI][checkJ] == 'X') return true;
		if(checkI == pi && checkJ == pj) return true;
		return isCaptureable(board,checkI,checkJ,i,j);
	}

	private boolean isRightCaptureable(char[][] board, int i, int j, int pi, int pj) {
		int checkI = i;
		int checkJ = j+1;
		if(checkI < 0 || checkI >= board.length) return false;
		if(checkJ < 0 || checkJ >= board.length) return false;
		if(board[checkI][checkJ] == 'X') return true;
		if(checkI == pi && checkJ == pj) return true;
		return isCaptureable(board,checkI,checkJ,i,j);
	}

	private boolean isLeftCaptureable(char[][] board, int i, int j, int pi, int pj) {
		int checkI = i;
		int checkJ = j-1;
		if(checkI < 0 || checkI >= board.length) return false;
		if(checkJ < 0 || checkJ >= board.length) return false;
		if(board[checkI][checkJ] == 'X') return true;
		if(checkI == pi && checkJ == pj) return true;
		return isCaptureable(board,checkI,checkJ,i,j);
	}

	private void captureRegion(char[][] board, int i, int j) {
		int nexti,nextj;
		//Capture current
		board[i][j] = 'X';
		//Capture left
		nexti = i; nextj = j-1;
		if(board[nexti][nextj] == 'O') captureRegion(board,nexti,nextj);
		
		//Capture right
		nexti = i; nextj = j+1;
		if(board[nexti][nextj] == 'O') captureRegion(board,nexti,nextj);
		
		//Capture top
		nexti = i-1; nextj = j;
		if(board[nexti][nextj] == 'O') captureRegion(board,nexti,nextj);
		
		//Capture bot
		nexti = i+1; nextj = j;
		if(board[nexti][nextj] == 'O') captureRegion(board,nexti,nextj);
	}

	public static void main(String[] args) {
		SurroundedRegions obj = new SurroundedRegions();
		char[][] board2 = new char[][]{
				{'X','X','X','X','X'},
				{'X','O','O','O','X'},
				{'X','X','O','O','X'},
				{'X','X','X','O','X'},
				{'X','O','X','X','X'}
		};
		obj.solve(board2);
		
		for(int i = 0 ; i < board2.length ; i++){
			for(int j = 0 ; j < board2.length ; j++){
				System.out.print(board2[i][j] + " ");
			}
			System.out.println();
		}
	}

}
