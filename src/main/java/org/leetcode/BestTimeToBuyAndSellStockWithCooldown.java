package org.leetcode;

public class BestTimeToBuyAndSellStockWithCooldown
{
	//Dynamic programming solution that works. But still time exceeded because of inner loops
	final int buy = 0;
	final int sell = 1;
	public int maxProfit(int[] prices)
	{
		if(prices == null || prices.length == 0)
			return 0;
		Integer[][][] profits = new Integer[prices.length][prices.length][2];
		for(int i = 0 ; i < prices.length; i++)
		{
			for(int j = 0 ; j < prices.length ; j++)
			{
				for(int k = 0; k < 2 ; k++)
				{
					profits[i][j][k] = null;
				}
			}
		}
		int maxProfit = findMaxProfit(prices, profits, 0, prices.length - 1, buy);
		return maxProfit;
    }

	private int findMaxProfit(int[] prices, Integer[][][] profits, int begin, int end, int op)
	{
		if(begin > end)
			return 0;
		if(begin >= prices.length || end >= prices.length)
			return 0;
		if(profits[begin][end][op] != null)
			return profits[begin][end][op];
		profits[begin][end][op] = 0;
		int maxProfit = 0;
		if(op == buy)
		{
			for(int i = begin ; i <= end ; i++)
			{
				int curProfit = -prices[i];
				curProfit += findMaxProfit(prices, profits, i+1, end, sell);
				if(curProfit > maxProfit)
					maxProfit = curProfit;
			}
		}
		else if(op == sell)
		{
			for(int i = begin ; i <= end ; i++)
			{
				int curProfit = prices[i];
				curProfit += findMaxProfit(prices, profits, i+2, end, buy);
				if(curProfit > maxProfit)
					maxProfit = curProfit;
			}
		}
		profits[begin][end][op] = maxProfit;
		return maxProfit;
	}

	public static void main(String[] args)
	{
		BestTimeToBuyAndSellStockWithCooldown obj = new BestTimeToBuyAndSellStockWithCooldown();
		int[] prices = {1, 2, 3, 0, 2};
		System.out.println("Max profit is " + obj.maxProfit(prices));
	}

}
