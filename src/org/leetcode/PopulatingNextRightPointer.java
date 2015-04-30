package org.leetcode;

//Accepted Solution
public class PopulatingNextRightPointer {

	public void connect(TreeLinkNode root) {
		if(root == null) return;
		root.next = null;
		startConnecting(root);
	}

	private void startConnecting(TreeLinkNode root) {
		if(root == null) return;
		TreeLinkNode left = root.left;
		TreeLinkNode right = root.right;
		if(left != null && right != null){
			left.next = right;
		}
		if(root.next != null){
			TreeLinkNode rightMost = (root.right != null) ? root.right : root.left;
			TreeLinkNode leftMost = null;
			leftMost = getLeftMostNephew(root.next);
			if(rightMost != null){
				rightMost.next = leftMost;
			}
		}
		startConnecting(root.right);
		startConnecting(root.left);
	}

	private TreeLinkNode getLeftMostNephew(TreeLinkNode root) {
		if(root == null) return null;
		TreeLinkNode sibling = root;
		TreeLinkNode leftMostNephew = null;
		do{
			if(sibling == null) break;
			if(sibling.left != null) leftMostNephew = sibling.left;
			else if(sibling.right != null) leftMostNephew = sibling.right;
			else sibling = sibling.next;
		}while(leftMostNephew == null);
		return leftMostNephew;
	}

	public static void main(String[] args) {
	}

}
