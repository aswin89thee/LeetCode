package org.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView
{
	//Accepted solution. 3ms runtime
	public List<Integer> rightSideView(TreeNode root)
	{
		List<Integer> list = new ArrayList<Integer>();
		if(root == null)
			return list;
		if(root.left == null && root.right == null)
		{
			list.add(root.val);
			return list;
		}
		LinkedList<TreeNode> levelQueue = new LinkedList<TreeNode>();
		levelQueue.add(root);
		while(!levelQueue.isEmpty())
		{
			list.add(levelQueue.getLast().val);
			LinkedList<TreeNode> newLevelQueue = new LinkedList<TreeNode>();
			while(!levelQueue.isEmpty())
			{
				TreeNode top = levelQueue.removeFirst();
				if(top.left != null)
					newLevelQueue.add(top.left);
				if(top.right != null)
					newLevelQueue.add(top.right);
			}
			levelQueue = newLevelQueue;
		}
		return list;
    }

	public static void main(String[] args)
	{
		BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2); root.left = two;
		TreeNode three = new TreeNode(3); root.right = three;
		TreeNode four = new TreeNode(4); two.left = four;
		List<Integer> ret = obj.rightSideView(root);
		System.out.println(ret.toString());
	}

}
