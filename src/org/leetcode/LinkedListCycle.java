package org.leetcode;

public class LinkedListCycle {
	
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode p1 = head, p2 = head;
        while(p2 != null){
        	p2 = p2.next != null ? p2 = p2.next.next : p2.next;
        	p1 = p1.next;
        	if(p1 == p2) return true;
        }
        return false;
    }
	public static void main(String[] args) {

	}

}
