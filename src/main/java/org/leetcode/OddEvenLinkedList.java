package org.leetcode;

/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList
{

	//Accepted solution with 1 ms runtime
	public ListNode oddEvenList(ListNode head)
	{
		if(head == null || head.next == null || head.next.next == null)
			return head;
		ListNode p1 = head;
		ListNode p2 = head.next;
		while(p2 != null && p2.next != null)
		{
			ListNode nextp2 = p2.next;
			ListNode nextp1 = p1.next;
			p2.next = nextp2.next;
			p2 = p2.next;
			nextp2.next = nextp1;
			p1.next = nextp2;
			p1 = p1.next;
		}
        return head;
    }

	public static void main(String[] args)
	{
		OddEvenLinkedList obj = new OddEvenLinkedList();
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2); head.next = n2;
		ListNode n3 = new ListNode(3); n2.next = n3;
		ListNode n4 = new ListNode(4); n3.next = n4;
		ListNode n5 = new ListNode(5); n4.next = n5;
		head = obj.oddEvenList(head);
		ListNode node = head;
		while(node != null)
		{
			System.out.print(node.val + "\t");
			node = node.next;
		}
	}

}
