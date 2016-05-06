package org.leetcode;

/*
 * Reverse a singly linked list.
 */
public class ReverseLinkedList
{
	//Accepted solution. ~0 ms runtime
	public ListNode reverseList(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		if(head.next.next == null)
		{
			ListNode next = head.next;
			next.next = head;
			head.next = null;
			head = next;
			return head;
		}
		ListNode prev = head;
		ListNode node = head.next;
		head.next = null;
		while(node.next != null)
		{
			ListNode next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		node.next = prev;
		head = node;
		return head;
    }
	
	public static void main(String[] args)
	{
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		a.next = b;
		b.next = c;
		c.next = null;
		ReverseLinkedList obj = new ReverseLinkedList();
		ListNode newHead = obj.reverseList(a);
		ListNode node = newHead;
		while(node != null)
		{
			System.out.print(node.val + "\t");
			node = node.next;
		}
	}

}
