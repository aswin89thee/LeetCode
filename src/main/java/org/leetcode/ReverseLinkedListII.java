package org.leetcode;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII
{
	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		if(head == null || m == n)
			return head;
		int count = 0;
		ListNode node = head;
		ListNode prev = null;
		while(node.next != null)
		{
			count++;
			if(count < m)
			{
				prev = node;
				node = node.next;
				continue;
			}
			if(count == m)
			{
				ListNode subhead = node;
				ListNode beforeStart = prev;
				count++;
				prev = node;
				node = node.next;
				while(count <= n)
				{
					count++;
					ListNode next = node.next;
					node.next = prev;
					prev = node;
					node = next;
				}
				ListNode subtail = prev;
				ListNode afterEnd = node;
				if(beforeStart != null)
					beforeStart.next = subtail;
				else
					head = subtail;
				subhead.next = afterEnd;
				
				break;
			}
		}
        return head;
    }

	public static void main(String[] args)
	{
		ReverseLinkedListII obj = new ReverseLinkedListII();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);a1.next = a2;
		ListNode a3 = new ListNode(3);a2.next = a3;
		ListNode a4 = new ListNode(4);a3.next = a4;
		ListNode a5 = new ListNode(5);a4.next = a5;
		ListNode newHead = obj.reverseBetween(a1, 1, 5);
		ListNode node = newHead;
		while(node != null)
		{
			System.out.print(node.val + "\t");
			node = node.next;
		}
	}
}
