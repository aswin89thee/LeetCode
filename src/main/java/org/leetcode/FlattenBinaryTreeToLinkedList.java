package org.leetcode;

/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBinaryTreeToLinkedList
{
	//Accepted solution with 1 ms runtime
    public void flatten(TreeNode root)
    {
    	if(root == null)
    		return;
    	flattenAndGetRightMost(root);
    }
    
	private TreeNode flattenAndGetRightMost(TreeNode node)
	{
		if(node.left == null && node.right == null)
			return node;
		TreeNode left = node.left;
		TreeNode right = node.right;
		node.left = null;
		if(left == null)
			return flattenAndGetRightMost(node.right);
		node.right = left;
		TreeNode bottom = flattenAndGetRightMost(left);
		if(right == null)
			return bottom;
		bottom.right = right;
		return flattenAndGetRightMost(right);
	}

	public static void main(String[] args)
	{
		FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node1.left = node2; node1.right = node5;
		node2.left = node3; node2.right = node4;
		node5.right = node6;
		obj.flatten(node1);
		TreeNode temp = node1;
		while(temp != null)
		{
			System.out.println(temp.val);
			temp = temp.right;
		}
	}

}
