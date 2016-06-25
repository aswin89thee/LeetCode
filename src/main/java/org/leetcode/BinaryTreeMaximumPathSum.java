package org.leetcode;

/*
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree 
along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class BinaryTreeMaximumPathSum
{

	//Accepted solution with 3 ms runtime
	int MAXSUM = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root)
    {
		int val = getMaxPathSum(root);
		return Integer.max(val,  MAXSUM);
    }
	
	private int getMaxPathSum(TreeNode node)
	{
		if(node == null)
			return 0;
		MAXSUM = Integer.max(MAXSUM, node.val);
		if(node.left == null && node.right == null)
		{
			return node.val;
		}
		int leftSum = 0, rightSum = 0;
		if(node.left != null)
		{
			leftSum = getMaxPathSum(node.left);
			MAXSUM = Integer.max(MAXSUM, leftSum);
			if(node.right == null)
			{
				return Integer.max(node.val, node.val+leftSum);
			}
		}
		if(node.right != null)
		{
			rightSum = getMaxPathSum(node.right);
			MAXSUM = Integer.max(MAXSUM, rightSum);
			if(node.left == null)
			{
				return Integer.max(node.val, node.val+rightSum);
			}
		}
		if(node.left != null && node.right != null)
			MAXSUM = Integer.max(MAXSUM, node.val + leftSum + rightSum);
		return Integer.max(node.val, node.val + Integer.max(leftSum, rightSum));
	}

	public static void main(String[] args)
	{
		BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
//		TreeNode root = new TreeNode(1);
//		TreeNode left = new TreeNode(2); root.left = left;
//		TreeNode right = new TreeNode(3); root.right = right;
		
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(-1); root.left = left;
		System.out.println(obj.maxPathSum(root));
	}

}
