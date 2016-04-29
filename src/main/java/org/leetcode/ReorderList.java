package org.leetcode;

import java.util.Stack;

public class ReorderList {
	
	public void reorderList(ListNode head) {
        if(head == null || head.next ==null || head.next.next == null){
        	return;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode onePointer = head;
        ListNode twoPointer = head;
        while(twoPointer.next != null){
        	onePointer = onePointer.next;
        	twoPointer = twoPointer.next.next != null ? twoPointer.next.next : twoPointer.next;
        }
        //Now onePointer points to the middle element
        while(onePointer != null){
        	stack.push(onePointer);
        	onePointer = onePointer.next;
        }
        //Now stack has the elements from last to the middle
        ListNode cursor = head;
        while(!stack.isEmpty() && cursor != null){
        	ListNode temp = stack.pop();
        	temp.next = cursor.next;
        	cursor.next = temp;
        	cursor = temp.next;
        }
        if(cursor != null) cursor.next = null;
    }

	public static void main(String[] args) {
	}

}
