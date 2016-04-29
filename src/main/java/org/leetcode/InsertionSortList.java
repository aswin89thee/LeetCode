package org.leetcode;

import java.util.Stack;



public class InsertionSortList {

	
	public ListNode insertionSortList(ListNode head) {
		Stack<ListNode> stack1 = new Stack<ListNode>();
		Stack<ListNode> stack2 = new Stack<ListNode>();
		for(ListNode cursor = head; cursor != null; cursor = cursor.next){
			ListNode cur = cursor;
			ListNode prev = null;
			if(!stack1.isEmpty())
				prev = stack1.pop();
			while( prev != null){
				if(prev.val > cur.val){
					int temp = prev.val;
					prev.val = cur.val;
					cur.val = temp;
					stack2.push(cur);
					stack2.push(prev);
					cur = prev;
					if(!stack1.isEmpty())
						prev = stack1.pop();
					else
						prev = null;
				}
				else{
					stack1.push(prev);
					while(!stack2.isEmpty()){
						stack1.push(stack2.pop());
					}
					break;
				}
			}
			if(!stack2.isEmpty()){
				while(!stack2.isEmpty()){
					stack1.push(stack2.pop());
				}
			}
			else
				stack1.push(cur);
		}
		return head;
	}

	public static void main(String[] args) {
		InsertionSortList obj = new InsertionSortList();
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(1);
		node1.next = node2; node2.next = node3;
		node1 = obj.insertionSortList(node1);
		obj.displayNodes(node1);
	}

	private void displayNodes(ListNode node) {
		while(node != null){
			System.out.print(node.val + " -> ");
			node = node.next;
		}
	}
	
	

}
