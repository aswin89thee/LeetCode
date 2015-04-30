package org.leetcode;

public class MergeTwoLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode aPointer = l1;
		ListNode bPointer = l2;
		ListNode newPointer = null;
		if(l1 == null){newPointer = l2; return newPointer;}
		if(l2 == null){newPointer = l1; return newPointer;}
		ListNode newTail = newPointer;
		while(true){
			if(aPointer == null){
				if(newPointer == null){newPointer = bPointer; break;}
				newTail.next = bPointer;
				break;
			}
			if(bPointer == null){
				if(newPointer == null){newPointer = aPointer; break;}
				newTail.next = aPointer;
				break;
			}
			if(aPointer.val < bPointer.val){
				if(newPointer == null){
					newPointer = aPointer;
					newTail = newPointer;
				}else{
					newTail.next = aPointer;
					newTail = newTail.next;
				}
				aPointer = aPointer.next;
			}
			else{ //bPointer < aPointer
				if(newPointer == null){
					newPointer = bPointer;
					newTail = newPointer;
				}else{
					newTail.next = bPointer;
					newTail = newTail.next;
				}
				bPointer = bPointer.next;
			}
		}

		return newPointer;
	}

	public static void main(String[] args) {
		MergeTwoLists obj = new MergeTwoLists();
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2); l2.next = l3;
		ListNode l4 = new ListNode(4); l3.next = l4;
		ListNode merged = obj.mergeTwoLists(l1, l2);

		while(merged != null){
			System.out.println(merged.val);
			merged = merged.next;
		}
	}
}
