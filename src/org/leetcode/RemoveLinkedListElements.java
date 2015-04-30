package org.leetcode;

public class RemoveLinkedListElements {
	
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		while(head != null && head.val == val){
			head = head.next;
		}
		if(head == null) return null;
		ListNode headptr = head;
		ListNode prev = head;
		head = head.next;
		while(head != null){
			if(head.val == val){
				while(head != null && head.val == val){
					head = head.next;
				}
				prev.next = head;
				continue;
			}
			head = head.next;
			prev = prev.next;
		}
        return headptr;
    }

	public static void main(String[] args) {
	}

}
