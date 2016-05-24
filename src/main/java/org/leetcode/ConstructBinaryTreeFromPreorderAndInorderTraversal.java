package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal
{

	//Accepted solution with 5 ms runtime
    Map<Integer,Integer> inorderIndexes = new HashMap<Integer,Integer>();
    int[] preorder = null;
    int[] inorder = null;
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
        if(preorder.length == 0 && inorder.length == 0)
        	return null;
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0 ; i < preorder.length ; i++)
        {
        	inorderIndexes.put(inorder[i], i);
        }
        TreeNode root = getTreeFromTraversal(0, preorder.length-1, 0, inorder.length-1);
        return root;
    }

	private TreeNode getTreeFromTraversal(int prestart, int preend, int instart, int inend)
	{
		if(prestart > preend || instart > inend)
			return null;
		TreeNode node = new TreeNode(preorder[prestart]);
		int inInd = inorderIndexes.get(preorder[prestart]);
		node.left = getTreeFromTraversal(prestart+1, prestart + (inInd - instart), instart, inInd-1);
		node.right = getTreeFromTraversal(prestart+1+(inInd-instart), preend, inInd+1, inend);
		return node;
	}

	public static void main(String[] args)
	{
		ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int[] preorder = {1,2,5,3,7};
		int[] inorder  = {2,5,1,3,7};
		TreeNode root = obj.buildTree(preorder, inorder);
		System.out.println("Built the tree. Its inorder traversal is:");
		obj.printInOrder(root);
	}

	private void printInOrder(TreeNode node)
	{
		if(node == null)
			return;
		printInOrder(node.left);
		System.out.print(node.val + " ");
		printInOrder(node.right);
	}

}
