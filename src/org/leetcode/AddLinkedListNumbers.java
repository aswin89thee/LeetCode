package org.leetcode;

public class AddLinkedListNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sum = null;
		ListNode sumTail = null;
		int carry = 0;
		ListNode aPointer = l1;
		ListNode bPointer = l2;
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		while(true){
			if(aPointer == null && bPointer == null) break;
			ListNode curSum = null;
			int val1 = aPointer == null? 0 : aPointer.val;
			int val2 = bPointer == null? 0 : bPointer.val;
			int sumVal = val1 + val2 + carry;
			carry = sumVal / 10;
			int curDigit = sumVal % 10;
			curSum = new ListNode(curDigit);
			if(sum == null){
				sum = curSum;
				sumTail = curSum;
			}
			else{
				sumTail.next = curSum;
				sumTail = sumTail.next;
			}
			if(aPointer != null) aPointer = aPointer.next;
			if(bPointer != null) bPointer = bPointer.next;
		}
		if(carry != 0){
			ListNode lastNode = new ListNode(carry);
			sumTail.next = lastNode;
		}
		
		return sum;
	}

	public static void main(String[] args) {

	}

}
