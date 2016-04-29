package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()){
			root = stack.pop();
			list.add(root.val);
			if(root.right != null){
				stack.add(root.right);
			}
			if(root.left != null){
				stack.add(root.left);
			}
		}
		return list;
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Map<TreeNode,Integer> processed = new HashMap<TreeNode,Integer>();
		stack.add(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			if(curNode == null) continue;
			if(processed.get(curNode) == null){
				list.add(curNode.val);
				processed.put(curNode, 0);
				stack.push(curNode);
				if(curNode.left != null)
					stack.push(curNode.left);
			}else{ //Already processed the left side
				if(curNode.right != null){
					stack.add(curNode.right);
				}
			}
		}
		
		return list;
	}
	
	public List<Integer> preorderTraversal3(TreeNode root)
	{
		List<Integer> list = new ArrayList<Integer>();
		recursePreorder(root,list);
		return list;
	}

	private void recursePreorder(TreeNode root, List<Integer> list) 
	{
		if(root == null || list == null)
			return;
		list.add(root.val);
		recursePreorder(root.left, list);
		recursePreorder(root.right, list);
	}

	public static void main(String[] args) {
		BinaryTreePreOrderTraversal obj = new BinaryTreePreOrderTraversal();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(2);
		node1.left = node2; node1.right = node3;
		List<Integer> list = obj.preorderTraversal3(node1);
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i) + " ");
			
		}
	}

}
