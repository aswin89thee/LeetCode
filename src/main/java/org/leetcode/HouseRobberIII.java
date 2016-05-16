package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

public class HouseRobberIII
{
	//Accepted solution with 1 ms runtime
	public int rob(TreeNode root)
    {
		if(root == null)
			return 0;
		int[] profits = getProfits(root);
		return Integer.max(profits[0], profits[1]);
    }
	//DP solution. For each we get the profits for its left and right sub-trees.
	//For a node, we return two values - the profit that includes the current node,
	//and the profit that excludes the current node.
	private int[] getProfits(TreeNode node)
	{
		if(node.left == null && node.right == null)
		{
			int[] profits = {node.val, 0};
			return profits;
		}
		
		int[] leftProfits = new int[2];
		if(node.left != null)
			leftProfits = this.getProfits(node.left);
		int[] rightProfits = new int[2];
		if(node.right != null)
			rightProfits = this.getProfits(node.right);
		//If the current node is included, we should only take the profits that excludes its direct children nodes
		//If the current node is excluded, we take the maximum of the subtree profits that may or may not include its direct children
		int includeProfit = node.val + leftProfits[1] + rightProfits[1];
		int excludeProfit = Integer.max(leftProfits[0], leftProfits[1]) + Integer.max(rightProfits[0], rightProfits[1]);
		int[] profits = {includeProfit, excludeProfit};
		return profits;
	}

	//My dumb dp solution. Time limit exceeded. Pretty sure it is correct though
	class NodeProfitInfo
	{
		TreeNode node;
		boolean parentIncluded = false;
		public NodeProfitInfo(TreeNode node, boolean parentIncluded)
		{
			this.node = node;
			this.parentIncluded = parentIncluded;
		}
	}
	Map<NodeProfitInfo, Integer> map = new HashMap<NodeProfitInfo,Integer>();
    public int rob2(TreeNode root)
    {
    	if(root == null)
    		return 0;
    	int maxProfit = 0;
    	maxProfit = getMaxProfit(root, false);
    	return maxProfit;
    }

	private int getMaxProfit(TreeNode node, boolean parentIncluded)
	{
		if(node.left == null && node.right == null)
		{
			if(parentIncluded)
				return 0;
			else
				return node.val;
		}
		NodeProfitInfo npinfo = new NodeProfitInfo(node, parentIncluded);
		if(this.map.get(npinfo) != null)
			return this.map.get(npinfo);
		int leftProfitWithCurNode = 0, leftProfitWithoutCurNode = 0;
		int rightProfitWithCurNode = 0, rightProfitWithoutCurNode = 0;
		if(node.left != null)
		{
			if(!parentIncluded)
				leftProfitWithCurNode = this.getMaxProfit(node.left, true);
			leftProfitWithoutCurNode = this.getMaxProfit(node.left, false);
		}
		if(node.right != null)
		{
			if(!parentIncluded)
				rightProfitWithCurNode = this.getMaxProfit(node.right, true);
			rightProfitWithoutCurNode = this.getMaxProfit(node.right, false);
		}
		int totalProfitWithCurNode = 0;
		if(!parentIncluded)
			totalProfitWithCurNode = leftProfitWithCurNode + rightProfitWithCurNode + node.val;
		int totalProfitWithoutCurNode = leftProfitWithoutCurNode + rightProfitWithoutCurNode;
		int maxProfit = Integer.max(totalProfitWithCurNode, totalProfitWithoutCurNode);
		this.map.put(npinfo, maxProfit);
		return maxProfit;
	}

	public static void main(String[] args)
	{
		HouseRobberIII obj = new HouseRobberIII();
		
		//Example 1 - expected answer : 7
//		TreeNode root = new TreeNode(3);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		root.left = node2; root.right = node3;
//		TreeNode node23 = new TreeNode(3);
//		TreeNode node1 = new TreeNode(1);
//		node2.right = node23; node3.right = node1;
		
		//Example 2 - expected answer: 9
		TreeNode root = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		root.left = node4; root.right = node5;
		TreeNode node11 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		node4.left = node11; node4.right = node3;
		TreeNode node21 = new TreeNode(1);
		node5.right = node21;
		
		
		System.out.println(obj.rob(root));
	}

}
