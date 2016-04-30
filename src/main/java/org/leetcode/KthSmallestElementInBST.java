package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

	public int kthSmallest(TreeNode root, int k) 
	{
		--k;
		List<Integer> list = new ArrayList<Integer>();
		traverseInOrderUntilK(root, list, k);
		return list.get(k);
	}

	//Stop doing the traversal when you've reached k elements. 
	//This saves the effort of going further than k elements and improves running time
	private void traverseInOrderUntilK(TreeNode root, List<Integer> list, int k)
	{
		if(root == null)
			return;
		traverseInOrderUntilK(root.left, list, k);
		if(list.size() > k)
			return;
		list.add(root.val);
		traverseInOrderUntilK(root.right, list, k);
	}

	public static void main(String[] args) 
	{
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2; node1.right = node3;
		KthSmallestElementInBST obj = new KthSmallestElementInBST();
		System.out.println(obj.kthSmallest(node1, 1));
	}

}
