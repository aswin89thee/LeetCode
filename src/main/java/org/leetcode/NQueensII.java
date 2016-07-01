package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII
{
	//Accepted solution with 47 ms runtime
	//This is the same as my algorithm for NQueens. I simply return the size of the list here
	public int totalNQueens(int n)
    {
        List<List<String>> solution = new ArrayList<List<String>>();
        solve(n, new ArrayList<String>(), solution);
        return solution.size();
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
}
