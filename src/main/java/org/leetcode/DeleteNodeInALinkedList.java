package org.leetcode;

/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class DeleteNodeInALinkedList
{
	//Accepted solution. 1 ms runtime
    public void deleteNode(ListNode node)
    {
        if(node == null || node.next == null)
        	return;
        ListNode prev = null;
        while(node.next != null)
        {
        	node.val = node.next.val;
        	prev = node;
        	node = node.next;
        }
        if(prev != null)
        	prev.next = null;
    }
    
	public static void main(String[] args)
	{
	}

}
