package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		Map<TreeNode,Integer> leftProcessed = new HashMap<TreeNode,Integer>(); 
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			if(curNode == null) continue;
			if(leftProcessed.get(curNode) == null){
				if(curNode.left != null){
					stack.push(curNode);
					stack.push(curNode.left);
					leftProcessed.put(curNode, 0);
				}
				else{
					list.add(curNode.val);
					leftProcessed.put(curNode, 0);
					if(curNode.right != null)
						stack.push(curNode.right);
				}
			}
			else{
				list.add(curNode.val);
				stack.push(curNode.right);
			}
		}
		return list;
	}
	
	//Use the presence of null as an indication that left node is processed. I prefer this solution as it avoids an extra map to store info about whether left node is processed
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode curNode = stack.pop();
			if(curNode != null)
			{
				stack.push(curNode);
				stack.push(null);
				if(curNode.left != null)
					stack.push(curNode.left);
			}
			else
			{
				if(stack.peek() == null)
					continue;
				curNode = stack.pop();
				list.add(curNode.val);
				if(curNode.right != null)
					stack.push(curNode.right);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		BinaryTreeInOrderTraversal obj = new BinaryTreeInOrderTraversal();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(2);
		node1.left = node2; node1.right = node3;
		List<Integer> list = obj.inorderTraversal2(node1);
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i) + " ");
			
		}
	}

}
