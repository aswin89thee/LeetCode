package org.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {
	Stack<List<Integer>> levelOrderStack = new Stack<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	if(root == null) return levelOrderStack;
		List<TreeNode> firstList = new ArrayList<TreeNode>();
		firstList.add(root);
		doLevelOrder(firstList);
		List<List<Integer>> bottomList = new ArrayList<List<Integer>>();
		while(!levelOrderStack.isEmpty()){
			bottomList.add(levelOrderStack.pop());
		}
        return bottomList;
    }
    
    private void doLevelOrder(List<TreeNode> prevList) {
		if(prevList == null || prevList.size() == 0) return;
		List<Integer> prevValList = new ArrayList<Integer>();
		for(TreeNode cur : prevList){
			if(cur != null)
				prevValList.add(cur.val);
		}
		levelOrderStack.push(prevValList);
		List<TreeNode> curList = new ArrayList<TreeNode>();
		for(TreeNode cur : prevList){
			if(cur != null){
				if(cur.left != null) curList.add(cur.left);
				if(cur.right != null) curList.add(cur.right);
			}
		}
		doLevelOrder(curList);
	}
}
