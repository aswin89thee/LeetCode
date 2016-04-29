package org.leetcode;

public class LinkedListCycleII {
	ListNode p1,p2;
	
    public ListNode detectCycle(ListNode head) {
    	if(!hasCycle(head)) return null;
    	p1 = head;
    	while(p1 != p2){
    		p1 = p1.next;
    		p2 = p2.next;
    	}
        return p1;
    }
    
    private boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        p1 = head;
        p2 = head;
        while(p2 != null){
        	p2 = p2.next != null ? p2 = p2.next.next : p2.next;
        	p1 = p1.next;
        	if(p1 == p2) return true;
        }
        return false;
    }
	public static void main(String[] args) {
		LinkedListCycleII obj = new LinkedListCycleII();
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2); node1.next = node2;
		ListNode node3 = new ListNode(0); node2.next = node3;
		ListNode node4 = new ListNode(-4); node3.next = node4; 
		node4.next = node2;
		ListNode cycleBegins = obj.detectCycle(node1);
		if(cycleBegins != null){
			System.out.println(cycleBegins.val);
		}
	}

}
