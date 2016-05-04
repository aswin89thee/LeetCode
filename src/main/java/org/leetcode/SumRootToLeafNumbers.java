package org.leetcode;

public class SumRootToLeafNumbers
{
	//Accepted solution with 2ms runtime
	public int sumNumbers(TreeNode root)
	{
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.val;
		int sum = getSumRootToLeaf(root, "");
		return sum;
    }
	private int getSumRootToLeaf(TreeNode root, String str)
	{
		if(root == null)
			return 0;
		str += root.val;
		if(root.left == null && root.right == null)
		{
			return Integer.parseInt(str);
		}
		return this.getSumRootToLeaf(root.left, str) + this.getSumRootToLeaf(root.right, str);
	}
	public static void main(String[] args)
	{
		SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2); root.left = left;
		TreeNode right = new TreeNode(3); root.right = right;
		System.out.println(obj.sumNumbers(root));
	}

}
