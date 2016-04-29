package org.leetcode;

import java.util.ArrayList;
import java.util.List;

//Accepted as a solution. Although, the question says it should use O(h) memory.
//This solution uses O(n) memory
//I don't know how it is possible to use O(h) memory and still run hasNext() and next() in constant time
public class BSTIterator {
	List<Integer> inOrderList = new ArrayList<Integer>();
	int index = 0;
	public BSTIterator(TreeNode root) {
		traverseTree(root);
    }

    private void traverseTree(TreeNode root) {
		if(root == null) return;
		traverseTree(root.left);
		inOrderList.add(root.val);
		traverseTree(root.right);
	}

	/** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return index < inOrderList.size();
    }

    /** @return the next smallest number */
    public int next() {
    	return inOrderList.get(index++);
    }
}
