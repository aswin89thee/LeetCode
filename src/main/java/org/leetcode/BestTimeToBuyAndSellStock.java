package org.leetcode;

/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
public class BestTimeToBuyAndSellStock
{
	
	public int maxProfit(int[] prices)
	{
		int len = prices.length;
		if(len <= 1)
			return 0;
		int profit = Integer.MIN_VALUE;
		int min = prices[0];
		for(int i = 1; i < len ; i++)
		{
			if(prices[i] < min)
				min = prices[i];
			if(prices[i] - min > profit)
				profit = prices[i] - min;
		}
		return profit;
    }

	public static void main(String[] args)
	{
		BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
		int[] prices = {2,6,1,1,3};
		System.out.println(obj.maxProfit(prices));
	}

}
