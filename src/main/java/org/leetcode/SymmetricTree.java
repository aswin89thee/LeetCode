package org.leetcode;

//Accepted
public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return compare(root.left,root.right);
	}

	private boolean compare(TreeNode n1, TreeNode n2) {
		if(n1 == null && n2 == null) return true;
		if(n1 == null || n2 == null) return false;
		if(n1.val != n2.val) return false;
		return compare(n1.left,n2.right) && compare(n1.right,n2.left);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);root.left = left;
		TreeNode right = new TreeNode(2);root.right = right;
		SymmetricTree obj = new SymmetricTree();
		System.out.println(obj.isSymmetric(root));
	}

}
