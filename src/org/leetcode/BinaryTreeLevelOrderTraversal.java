package org.leetcode;

import java.util.ArrayList;
import java.util.List;

//At each iteration (or recursive call), you have two queues. One for the elements in the previous level (prevList) and another for the current level (curList)
//Take each element in the prevList and add its children to the curList and recurse until prevList is empty
public class BinaryTreeLevelOrderTraversal {
	List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return levelOrderList;
		List<TreeNode> firstList = new ArrayList<TreeNode>();
		firstList.add(root);
		doLevelOrder(firstList);
        return levelOrderList;
    }
	
	private void doLevelOrder(List<TreeNode> prevList) {
		if(prevList == null || prevList.size() == 0) return;
		List<Integer> prevValList = new ArrayList<Integer>();
		for(TreeNode cur : prevList){
			if(cur != null)
				prevValList.add(cur.val);
		}
		levelOrderList.add(prevValList);
		List<TreeNode> curList = new ArrayList<TreeNode>();
		for(TreeNode cur : prevList){
			if(cur != null){
				if(cur.left != null) curList.add(cur.left);
				if(cur.right != null) curList.add(cur.right);
			}
		}
		doLevelOrder(curList);
	}

	public static void main(String[] args) {

	}

}
