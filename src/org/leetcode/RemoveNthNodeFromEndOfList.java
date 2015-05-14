package org.leetcode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null) return head;
    	if(head.next == null && n > 0) return null;
    	ListNode fakeHead = new ListNode(-1); fakeHead.next = head;
    	ListNode p1 = fakeHead, p2 = fakeHead;
    	for(int i = 0 ; i < n ; i++){
    		p2 = p2.next;
    	}
    	while(p2 != null && p2.next != null){
    		p2 = p2.next;
    		p1 = p1.next;
    	}
    	p1.next = p1.next.next;
    	head = fakeHead.next;
        return head;
	}
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2); node1.next = node2;
		ListNode head = obj.removeNthFromEnd(node1, 2);
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}
