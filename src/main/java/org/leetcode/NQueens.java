package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.


Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class NQueens
{

	//Accepted solution with 48 ms runtime.
	//This solution is based on BFS and backtracking
    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> solution = new ArrayList<List<String>>();
        solve(n, new ArrayList<String>(), solution);
        return solution;
    }
    
	private void solve(int n, List<String> curSeq, List<List<String>> solution)
	{
		if(curSeq.size() == n)
		{
			solution.add(new ArrayList<String>(curSeq));
			return;
		}
		String row = "";
		int i = 0;
		for(i = 0 ; i < n ; i++)
			row += ".";
		for(i = 0 ; i < n ; i++)
		{
			String curRow = row.substring(0, i) + "Q" + row.substring(i+1);
			if(isValidPosition(curSeq, curRow))
			{
				curSeq.add(curRow);
				solve(n, curSeq, solution);
				curSeq.remove(curRow);
			}
		}
	}

	private boolean isValidPosition(List<String> board, String newRow)
	{
		if(board.size() == 0)
			return true;
		int qIndex = newRow.indexOf('Q');
		
		//Check vertically going up from the Queen position
		for(String cur : board)
		{
			if(cur.charAt(qIndex) == 'Q')
				return false;
		}
		
		//Check diagonally going up and left
		int i = board.size() - 1;
		int j = qIndex - 1;
		while(i >= 0 && j >= 0)
		{
			if(board.get(i).charAt(j) == 'Q')
				return false;
			i--;
			j--;
		}
		
		//Check diagonally going up and right
		i = board.size() - 1;
		j = qIndex + 1;
		while(i >= 0 && j < newRow.length())
		{
			if(board.get(i).charAt(j) == 'Q')
				return false;
			i--;
			j++;
		}
		
		return true;
	}

	public static void main(String[] args)
	{
		NQueens obj = new NQueens();
		int n = 3;
		List<List<String>> solutions = obj.solveNQueens(n);
		System.out.println("With n = " + n + ", there are " + solutions.size() + " solutions");
		for(List<String> solution : solutions)
		{
			System.out.println("\n\n");
			for(String row : solution)
				System.out.println(row);
		}
	}

}
