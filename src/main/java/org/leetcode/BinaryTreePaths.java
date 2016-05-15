package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:


 */
public class BinaryTreePaths
{
	//Accepted solution with 4 ms runtime
    public List<String> binaryTreePaths(TreeNode root)
    {
    	List<String> paths = new ArrayList<String>();
    	if(root == null)
    		return paths;
    	return getTreePaths(root, "");
    }
    
	private List<String> getTreePaths(TreeNode root, String path)
	{
		if(root.left == null && root.right == null)
		{
			if(!path.isEmpty())
			{
				path += "->";
			}
			path = path + root.val;
			List<String> list = new ArrayList<String>();
			list.add(path);
			return list;
		}
		if(!path.isEmpty())
		{
			path += "->";
		}
		path = path + root.val;
		List<String> paths = new ArrayList<String>();
		if(root.left != null)
			paths.addAll(getTreePaths(root.left, path));
		if(root.right != null)
			paths.addAll(getTreePaths(root.right, path));
		return paths;
	}

	public static void main(String[] args)
	{
		BinaryTreePaths obj = new BinaryTreePaths();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2; node1.right = node3;
		node2.right = node5;
		List<String> paths = obj.binaryTreePaths(node1);
		for(String str : paths)
			System.out.println(str);
	}
}
