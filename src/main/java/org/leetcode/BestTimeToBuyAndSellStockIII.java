package org.leetcode;


/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
   Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII
{
	//Accepted solution with 3 ms runtime 
	public int maxProfit(int[] prices)
	{
		int len = prices.length;
		if(len <= 1)
			return 0;
		int[] left = new int[len];
		int[] right = new int[len];
		int min = prices[0];
		left[0] = 0;
		//Find max profit to the left of i
		for(int i = 1 ; i < len ; i++)
		{
			if(prices[i] < min)
				min = prices[i];
			left[i] = Integer.max(left[i - 1], prices[i] - min);
		}
		
		//Find max profit to the right of i
		right[len - 1] = 0;
		int max = prices[len - 1];
		for(int i = len - 2 ; i >= 0 ; i--)
		{
			if(prices[i] > max)
				max = prices[i];
			right[i] = Integer.max(right[i + 1], max - prices[i]);
		}
		
		//Max profit is the maximum of left+right
		int maxprofit = Integer.MIN_VALUE;
		for(int i  = 0 ; i < len ; i++)
		{
			if(left[i] + right[i] > maxprofit)
				maxprofit = left[i] + right[i];
		}
		return maxprofit;
    }
	public static void main(String[] args)
	{
		BestTimeToBuyAndSellStockIII obj = new BestTimeToBuyAndSellStockIII();
		int[] prices = {1,3,2,4,2};
		System.out.println(obj.maxProfit(prices));
	}

}
