package org.leetcode;

public class ReverseBits {
	public int reverseBits(int n) {
        long reverseNum = 0;
        for(int i = 0 ; i < 32 ; i++){
        	if((n & (1 << i)) > 0){
        		reverseNum |= (1 << (31-i));
        	}
        }
        return (int)reverseNum;
    }
	
		public static void main(String[] args) {
		ReverseBits obj = new ReverseBits();
		System.out.println(obj.reverseBits(43261596));;
	}

}
