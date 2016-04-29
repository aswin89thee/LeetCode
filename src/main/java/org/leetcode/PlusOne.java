package org.leetcode;

public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		int carry = 0;
		int lastSum = digits[digits.length-1] + 1;
		carry = lastSum/10;
		int newLastDigit = lastSum%10;
		digits[digits.length-1] = newLastDigit;
		for(int i = digits.length-2 ; i>=0 ; i--){
			int sum = digits[i] + carry;
			digits[i] = sum % 10;
			carry = sum/10;
		}
		if(carry > 0){
			int[] newDigits = new int[digits.length+1];
			newDigits[0] = carry;
			for(int i = 1; i< newDigits.length ; i++){
				newDigits[i] = digits[i-1];
			}
			return newDigits;
		}
		return digits;
	}

	public static void main(String[] args) {
	}

}
