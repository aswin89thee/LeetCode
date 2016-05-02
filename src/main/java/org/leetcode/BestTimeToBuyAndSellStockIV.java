package org.leetcode;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIV {
	
	//Dynamic programming solution. But still time limit exceeded. Works on my test cases
	public int maxProfit(int k, int[] prices)
	{
		if(k <= 0)
			return 0;
		if(prices.length <= 1)
			return 0;
		Integer[][] profits = new Integer[prices.length][k+1];
		int maxprofit = getMaxProfit(prices, k, 0, profits);
		for(int i = 0 ; i < prices.length ; i++)
		{
			System.out.println();
			for(int j = 0 ; j < k+1 ; j++)
			{
				System.out.print(j + "\t");
			}
		}
		return maxprofit;
    }

	private int getMaxProfit(int[] prices, int k, int day, Integer[][] profits)
	{
		if(k <= 0)
			return 0;
		if(day >= prices.length - 1)
			return 0;
		if(profits[day][k] != null)
			return profits[day][k];
		int maxprofit = Integer.MIN_VALUE;
		int curprofit = Integer.MIN_VALUE;
		int min = prices[day];
		for(int i = day + 1 ; i < prices.length ; i++)
		{
			if(prices[i] < min)
			{
				min = prices[i];
				curprofit = 0;
				continue;
			}
			if(prices[i] - min > curprofit)
			{
				curprofit = prices[i] - min;
				int restProfit = getMaxProfit(prices, k-1, i+1, profits);
				if(curprofit + restProfit > maxprofit)
					maxprofit = curprofit + restProfit;
			}
		}
		if(maxprofit == Integer.MIN_VALUE)
			maxprofit = 0;
		profits[day][k] = maxprofit;
		return maxprofit;
	}

	public static void main(String[] args)
	{
		BestTimeToBuyAndSellStockIV obj = new BestTimeToBuyAndSellStockIV();
		int[] prices = {5,2,6,3,4,2,1};
		System.out.println(obj.maxProfit(3, prices));
	}

}
