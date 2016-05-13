package org.leetcode;

/*
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList
{

	//Accepted solution with 2 ms runtime
	//Approach: Use two pointers to reach the middle of the list, and then reverse the second half
	//Then compare both the halves to see if they are equal.
	//This method is O(n) with constant space
    public boolean isPalindrome(ListNode head)
    {
    	//Just to be safe, cover base cases up to three nodes
    	if(head == null || head.next == null)
    		return true;
    	if(head.next.next == null)
    		return head.val == head.next.val;
    	if(head.next.next.next == null)
    		return head.val == head.next.next.val;
    	ListNode onePtr = head;
    	ListNode twoPtr = head;
    	ListNode onePtrPrev = null;
    	ListNode secondHalfHead = null;
    	while(twoPtr.next != null && twoPtr.next.next != null)
    	{
    		twoPtr = twoPtr.next.next;
    		onePtrPrev = onePtr;
    		onePtr = onePtr.next;
    	}
    	//Two cases - odd number of elements in the linked list, or even number of elements
    	//We can find it out using the position of twoPtr
    	if(twoPtr.next == null)
    	{
    		//Odd number of elements. Skip the middle element
    		onePtrPrev.next = null;
    	}
		secondHalfHead = onePtr.next;
		onePtr.next = null;
    	
    	//Reverse the second half
    	secondHalfHead = reverseList(secondHalfHead);
    	
    	//Compare head and secondHalfHead element by element
    	while(head != null && secondHalfHead != null)
    	{
    		if(head.val != secondHalfHead.val)
    			return false;
    		head = head.next;
    		secondHalfHead = secondHalfHead.next;
    	}
    	return true;
    }
    
	private ListNode reverseList(ListNode head)
	{
		ListNode prev = null;
		ListNode node = head;
		while(node != null)
		{
			ListNode temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}
		head = prev;
		return head;
	}

	public static void main(String[] args)
	{
		PalindromeLinkedList obj = new PalindromeLinkedList();
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);
		head.next = node2; 
		node2.next = node4;
		node3.next = node4;
		node4.next = node5;
		System.out.println(obj.isPalindrome(head));
		
	}

}
