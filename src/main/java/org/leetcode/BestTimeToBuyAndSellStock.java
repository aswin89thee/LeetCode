package org.leetcode;

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
