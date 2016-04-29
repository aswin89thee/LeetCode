package org.leetcode;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		if(board.length != 9) return false;
		//Check rows
		int i,j;
		for(i = 0 ; i < board.length ; i++){
			int[] charMap = new int[256];
			for(j=0 ; j<board[i].length ; j++){
				if(board[i][j] =='.') continue;
				char ch = board[i][j];
				if(charMap[ch]>0) return false;
				charMap[ch]++;
			}
		}
		//Check columns
		for(i = 0 ; i < board.length ; i++){
			int[] charMap = new int[256];
			for(j=0 ; j<board[i].length ; j++){
				if(board[j][i] =='.') continue;
				char ch = board[j][i];
				if(charMap[ch]>0) return false;
				charMap[ch]++;
			}
		}
		//Check grid
		return areGridsValid(board);
	}

	private boolean areGridsValid(char[][] board) {
		int a = 0, b = 0;
		for(a = 0 ; a <= 6 ; a+=3){
			for(b = 0 ; b <= 6 ; b+= 3){
				boolean isValidGrid = true;
				isValidGrid = checkGrid(board,a,b);
				if(!isValidGrid) return false;
			}
		}
		return true;
	}

	private boolean checkGrid(char[][] board, int a, int b) {
		int[] charMap = new int[256];
		int i = a, j = b;
		for(i=a ; i<a+3 ; i++){
			for(j=b ; j< b+3 ; j++){
				if(board[i][j] == '.') continue;
				char ch = board[i][j];
				if(charMap[ch] > 0) return false;
				charMap[ch]++;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
