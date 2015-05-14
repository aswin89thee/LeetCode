package org.leetcode;

public class RemoveDuplicatesFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode prevValid = head;
		if(head == null || head.next == null) return head;
		head = findProperHead(head);
		if(head == null) return null;
		prevValid = head;
		ListNode cursor = head;
		ListNode removing = null;
		while(cursor != null){
			if(removing != null){
				if(cursor.val == removing.val){
					cursor = cursor.next;
					continue;
				}else{
					prevValid.next = cursor;
					if(cursor.next != null){
						if (cursor.val != cursor.next.val){
							removing = null;
							prevValid = cursor;
							cursor = cursor.next;
							continue;
						}else{
							removing = cursor;
							cursor = cursor.next;
							continue;
						}
					}else{
						if(cursor.val == removing.val){
							prevValid.next = null;
							removing = null;
						}else{
							prevValid.next = cursor;
							removing = null;
						}
					}
				}
			}else{ //removing = null
				if(cursor.next != null && cursor.val == cursor.next.val){
					removing = cursor;
				}
				else{
					prevValid = cursor;
				}
			}
			cursor = cursor.next;
		}
		if(removing != null){
			if(prevValid != null){
				prevValid.next = null;
			}
		}
		return head;
	}

	private ListNode findProperHead(ListNode head) {
		if(head == null) return null;
		if(head.next == null) return head;
		if(head.val != head.next.val) return head;
		int recurringVal = -1;
		boolean recurring = false;
		if(head.next != null && head.val == head.next.val){
			recurring = true;
			recurringVal = head.val;
		}
		while(head.next != null && head.val == head.next.val){
			head = head.next;
		}
		if(recurring && recurringVal == head.val){
			head = head.next;
		}
		return findProperHead(head);
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2); node1.next = node2;
		ListNode node31 = new ListNode(3); node2.next = node31;
		ListNode node32 = new ListNode(3); node31.next = node32;
		ListNode node41 = new ListNode(4); node32.next = node41;
		ListNode node42 = new ListNode(4); node41.next = node42;
		ListNode node5 = new ListNode(5); node42.next = node5;
		RemoveDuplicatesFromSortedListII obj = new RemoveDuplicatesFromSortedListII();
		ListNode head = obj.deleteDuplicates(node1);
		while(head!= null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
