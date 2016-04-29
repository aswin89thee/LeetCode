package org.leetcode;

public class MaximumDepth {
	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return leftMax > rightMax ? leftMax+1 : rightMax+1;
    }
	public static void main(String[] args) {

	}

}
