package org.leetcode;

import java.util.ArrayList;
import java.util.List;

//Wrong Answer. 200/211 Test cases passed. Not DP solution. I tried to use greedy approach and it failed
public class BestTimeToBuyAndSellStockIV {
	
	public int maxProfit(int k, int[] prices) {
        int maxProf = 0;
        if(prices==null || prices.length==0 || k<1) return maxProf;
        List<Integer> profitList = new ArrayList<Integer>();
        int begin = 0, end=0;
        for(int i = 0 ; i < prices.length ; i++){
        	if(prices[i] < prices[begin]){
        		begin = end = i;
        	}
        	if(prices[i] > prices[end]){
        		end = i;
        	}
        	if(i == prices.length-1){
        		if(end > begin && prices[end] > prices[begin]){
        			addToProfitList(prices,begin,end,k,profitList);
        		}
        	}else{
        		if(prices[i+1] < prices[i]){
        			addToProfitList(prices,begin,end,k,profitList);
        			begin = end = i+1;
        		}
        	}
        }
        for(Integer cur : profitList){
        	maxProf += cur;
        }
        return maxProf;
    }

	private void addToProfitList(int[] prices, int begin, int end, int k, List<Integer> profitList) {
		int curProfit = prices[end] - prices[begin];
		if(profitList.size() < k){
			profitList.add(curProfit);
			return;
		}
		int minVal = Integer.MAX_VALUE;
		for(Integer cur : profitList){
			if(cur < minVal){
				minVal = cur;
			}
		}
		if(curProfit > minVal){
			profitList.remove(new Integer(minVal));
			profitList.add(curProfit);
		}
	}

	public static void main(String[] args) {

	}

}
