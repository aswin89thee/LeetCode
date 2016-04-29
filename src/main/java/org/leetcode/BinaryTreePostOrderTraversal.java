package org.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
	
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	root = stack.pop();
        	list.add(root.val);
        	if(root.left != null){
        		stack.add(root.left);
        	}
        	if(root.right != null){
        		stack.add(root.right);
        	}
        }
        List<Integer> newList = new ArrayList<Integer>();
        for(int i = list.size()-1 ; i >= 0 ; i--){
        	newList.add(list.get(i));
        }
        
        return newList;
    }
	public static void main(String[] args) {
		BinaryTreePostOrderTraversal obj = new BinaryTreePostOrderTraversal();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(2);
		node1.left = node2; node1.right = node3;
		List<Integer> list = obj.postorderTraversal(node1);
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i) + " ");
			
		}
	}

}
