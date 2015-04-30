package org.leetcode;

public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		TreeNode root = null;
		if(head == null) return null;
		if(head.next == null){
			root = new TreeNode(head.val);root.left = null; root.right = null;
			return root;
		}
		if(head.next.next == null){
			root = new TreeNode(head.val);root.left = null;
			TreeNode rightChild = new TreeNode(head.next.val);rightChild.left=null;rightChild.right=null;
			root.right = rightChild;
			return root;
		}
		ListNode onePointer = head, twoPointer = head, prev = head;
		while(twoPointer != null && twoPointer.next != null){
			if(prev != onePointer){
				prev = prev.next;
			}
			onePointer = onePointer.next;
			if(twoPointer.next == null){
				twoPointer = twoPointer.next;
			}else{
				twoPointer = twoPointer.next.next;
			}
		}
		//Now onePointer points to the middle element of the sorted list. Break it to form the root of the new tree
		prev.next = null;
		root = new TreeNode(onePointer.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(onePointer.next);
		return root;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(8);
		node1.next = node2; node2.next = node3;
		ConvertSortedListToBinarySearchTree obj = new ConvertSortedListToBinarySearchTree();
		obj.sortedListToBST(node1);
	}

}
