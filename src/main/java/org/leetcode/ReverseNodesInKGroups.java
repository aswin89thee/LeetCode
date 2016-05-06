package org.leetcode;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroups
{
	
	//Accepted solution with 1 ms runtime
	public ListNode reverseKGroup(ListNode head, int k)
	{
		if(head == null || k <= 1)
			return head;
		ListNode node = head;
		int totalNodes = 0;
		while(node != null)
		{
			totalNodes++;
			node = node.next;
		}
		if(k > totalNodes)
			return head;
		int reverseCount = totalNodes / k;
		int reversalIter = 0;
		int curCount = 0;
		node = head;
		ListNode prev = null;
		ListNode beforeStart = null;
		while(reversalIter < reverseCount)
		{
			ListNode subHead = node;
			while(curCount < k)
			{
				ListNode next = node.next;
				node.next = prev;
				prev = node;
				node = next;
				curCount++;
			}
			ListNode subtail = prev;
			ListNode afterEnd = node;
			if(beforeStart != null)
				beforeStart.next = subtail;
			else
				head = subtail;
			subHead.next = afterEnd;
			//Prepare for next iteration
			curCount = 0;
			reversalIter++;
			beforeStart = subHead;
			prev = subHead;
		}
		return head;
    }

	public static void main(String[] args)
	{
		ReverseNodesInKGroups obj = new ReverseNodesInKGroups();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2); a.next = b;
		ListNode c = new ListNode(3); b.next = c;
		ListNode d = new ListNode(4); c.next = d;
		ListNode e = new ListNode(5); d.next = e;
		ListNode f = new ListNode(6); e.next = f;
		
		ListNode newHead = obj.reverseKGroup(a, 2);
		ListNode node = newHead;
		while(node != null)
		{
			System.out.print(node.val + "\t");
			node = node.next;
		}
	}

}
