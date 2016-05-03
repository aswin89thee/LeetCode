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
	
	//Accepted solution. 11 ms runtime 
	//Note: This is a slow solution, since BigDecimal operations are slow
	public List<Integer> getRow(int rowIndex)
	{
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		for(int i = 1 ; i < rowIndex ; i++)
		{
			BigDecimal bd1 = new BigDecimal(row.get(i - 1));
			BigDecimal bd2 = new BigDecimal(rowIndex - i + 1);
			BigDecimal bd3 = new BigDecimal(i);
			BigDecimal bdelt = bd1.multiply(bd2).divide(bd3);
			row.add(bdelt.intValue());
		}
		if(row.size() == rowIndex)
			row.add(1);
		return row;
    }

	public static void main(String[] args) {
		PascalTriangleII obj = new PascalTriangleII();
		System.out.println(obj.getRow(30));
	}

}
