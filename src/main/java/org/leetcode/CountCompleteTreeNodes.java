package org.leetcode;

/*
 * Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes
{

	//Accepted solution with 114 ms runtime
	public int countNodes(TreeNode root)
    {
		if(root == null)
			return 0;
		int leftHeight = getLeftHeight(root) + 1;
		int rightHeight = getRightHeight(root) + 1;
		if(leftHeight == rightHeight)
			return (2<<(leftHeight-1))-1;
		//If I write a Math.pow(2, leftHeight) above instead of bit manipulation, 
		//LeetCode says time limit exceeded
		
		int count = countNodes(root.left) + countNodes(root.right) + 1;
		return count;
    }
	private int getLeftHeight(TreeNode node)
	{
		if(node == null)
			return 0;
		int height = 0;
		while(node.left != null)
		{
			height++;
			node = node.left;
		}
		return height;
	}
	private int getRightHeight(TreeNode node)
	{
		if(node == null)
			return 0;
		int height = 0;
		while(node.right != null)
		{
			height++;
			node = node.right;
		}
		return height;
	}

	//Initial attempt. Time limit exceeded
	int leafCount = 0;
    public int countNodes2(TreeNode root)
    {
    	if(root == null)
    		return 0;
    	if(root.left == null && root.right == null)
    		return 1;
    	int height = getTreeHeight(root);
    	System.out.println("Height of tree is " + height);
    	int twoPowH = (int)Math.pow(2, height);
    	int nodeCount = twoPowH - 1;//Total number of internal nodes
    	getLeafCount(root, 0, height);
    	nodeCount += leafCount;
    	return nodeCount;
    }
    
	private void getLeafCount(TreeNode root, int i, int height)
	{
		if(i == height)
		{
			leafCount++;
			return;
		}
		if(root.left != null)
			getLeafCount(root.left, i+1, height);
		if(root.right != null)
			getLeafCount(root.right, i+1, height);
	}

	private int getTreeHeight(TreeNode node)
	{
		if(node.left == null && node.right == null)
			return 0;
		int height = 0;
		if(node.left != null)
		{
			height = 1 + getTreeHeight(node.left);
		}
		if(node.right != null)
		{
			int rightHeight = 1 + getTreeHeight(node.right);
			height = (rightHeight > height) ? rightHeight : height;
		}
		return height;
	}

	public static void main(String[] args)
	{
		CountCompleteTreeNodes obj = new CountCompleteTreeNodes();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2; node1.right = node3;
		node2.left = node4;
		System.out.println(obj.countNodes(node1));
	}

}
