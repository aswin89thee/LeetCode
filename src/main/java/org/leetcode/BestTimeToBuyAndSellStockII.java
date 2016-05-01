package org.leetcode;

/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
*/
public class BestTimeToBuyAndSellStockII
{
	public int maxProfit(int[] prices)
	{
		if(prices.length <= 1)
			return 0;
		int profit = 0;
		for(int i = 1 ; i < prices.length ; i++)
		{
			int diff = prices[i] - prices[i - 1];
			if(diff > 0)
				profit += diff;
		}
		return profit;
    }
	public static void main(String[] args)
	{
		BestTimeToBuyAndSellStockII obj = new BestTimeToBuyAndSellStockII();
		int[] prices = {1,3,2,4,2};
		System.out.println(obj.maxProfit(prices));
	}
}
