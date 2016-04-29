package org.leetcode;

public class RemoveDuplicatesFromSortedList {
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode cur = head;
		ListNode next = head.next;
		while(cur != null){
			if(next == null) break;
			if(next.val != cur.val){
				cur = next;
				next = next.next;
				continue;
			}
			while(next != null && next.val == cur.val){
				next = next.next;
			}
			cur.next = next;
			cur = next;
			if(next == null) break;
			next = next.next;
		}
		
		head = fakeHead.next;
		return head;
    }

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);node1.next = node2;
		ListNode node3 = new ListNode(2);node2.next = node3;
		ListNode node4 = new ListNode(3);node3.next = node4;
		ListNode node5 = new ListNode(3);node4.next = node5;
		ListNode newHead = obj.deleteDuplicates(node1);
		while(newHead != null){
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}

}
