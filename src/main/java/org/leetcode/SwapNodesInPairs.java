package org.leetcode;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs
{

	//Accepted solution with 0 ms runtime
    public ListNode swapPairs(ListNode head)
    {
        if(head == null || head.next == null)
        	return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode cur = head;
        while(cur != null && cur.next != null)
        {
        	ListNode nxt = cur.next;
        	prev.next = nxt;
        	cur.next = nxt.next;
        	nxt.next = cur;
        	prev = cur;
        	cur = cur.next;
        }
        head = fakeHead.next;
        return head;
    }
    
	public static void main(String[] args)
	{
		SwapNodesInPairs obj = new SwapNodesInPairs();
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2); head.next = n2;
		ListNode n3 = new ListNode(3); n2.next = n3;
		ListNode n4 = new ListNode(4); n3.next = n4;
		head = obj.swapPairs(head);
		ListNode node = head;
		while(node != null)
		{
			System.out.print(node.val + "\t");
			node = node.next;
		}
	}

}
