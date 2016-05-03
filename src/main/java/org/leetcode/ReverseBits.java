package org.leetcode;

public class ReverseBits {
	
	//3ms runtime. Thanks to www.programcreek.com for the solution
	public int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			n = swapBits(n, i, 32 - i - 1);
		}

		return n;
	}

	public int swapBits(int n, int i, int j) {
		int a = (n >> i) & 1;
		int b = (n >> j) & 1;

		if ((a ^ b) != 0) {
			return n ^= (1 << i) | (1 << j);
		}

		return n;
	}

	public static void main(String[] args) {
		ReverseBits obj = new ReverseBits();
		System.out.println(obj.reverseBits(43261596));;
	}

}
