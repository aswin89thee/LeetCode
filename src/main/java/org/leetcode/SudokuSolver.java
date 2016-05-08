package org.leetcode;

/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
 */
public class SudokuSolver
{
	
	//Accepted solution. 462 ms runtime
    public void solveSudoku(char[][] board)
    {
    	if(board == null || board.length == 0)
            return;
    	solve(board);
    }
    
	private boolean solve(char[][] board)
	{
		for(int i = 0 ; i < board.length ; i++)
		{
			for(int j = 0 ; j < board.length ; j++)
			{
				if(board[i][j] != '.')
					continue;
				for(char ch = '1' ; ch <= '9' ; ch++)
				{
					board[i][j] = ch;
					if(!this.isValidSudoku(board))
					{
						board[i][j] = '.';
						continue;
					}
					boolean success = this.solve(board);
					if(success)
						return success;
					board[i][j] = '.';
				}
				//None of the digits work. Return false to help backtracking
				return false;
			}
		}
		return true;
	}
	
	private boolean isValidSudoku(char[][] board) {
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
	
	public static void main(String[] args)
	{
		SudokuSolver obj = new SudokuSolver();
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		obj.solveSudoku(board);
		for(int i = 0 ; i < board.length ; i++)
		{
			System.out.println();
			for(int j = 0 ; j < board.length ; j++)
			{
				System.out.print(board[i][j] + "\t");
			}
		}
	}
}
