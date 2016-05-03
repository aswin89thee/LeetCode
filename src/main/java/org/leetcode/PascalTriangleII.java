package org.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
	
	//Accepted solution. 1 ms runtime 
	//I'm using this formula:
	//pascal[n][r] = pascal[n][r-1] * (n-r+1) / r
	public List<Integer> getRow(int rowIndex)
	{
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		for(int i = 1 ; i < rowIndex ; i++)
		{
			double factor = (rowIndex - i + 1)/(double)i;
			double elt = row.get(i - 1) * factor;
			int val = (int)Math.round(elt);
			row.add(val);
		}
		if(row.size() == rowIndex)
			row.add(1);
		return row;
    }

	public static void main(String[] args) {
		PascalTriangleII obj = new PascalTriangleII();
		System.out.println(obj.getRow(0));
	}

}
