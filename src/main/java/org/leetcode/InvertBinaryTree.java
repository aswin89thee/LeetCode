package org.leetcode;

public class InvertBinaryTree
{
	//Accepted solution. ~0 ms
	public TreeNode invertTree(TreeNode root)
	{
		if(root == null || (root.left == null && root.right == null))
			return root;
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
		invertTree(root.left);
		invertTree(root.right);
		return root;
    }
	
	public static void main(String[] args)
	{
	}

}
