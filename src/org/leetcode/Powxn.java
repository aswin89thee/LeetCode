package org.leetcode;

public class Powxn {
	
	public double myPow(double x, int n) {
        double result = 1;
        int newN = n > 0 ? n : -n;
        while(newN > 0){
        	while((newN % 2) == 0){
        		newN = newN/2;
        		x *= x;
        	}
        	result *= x;
        	newN--;
        }
        
        return n > 0 ? result : 1.0/result;
    }

	public static void main(String[] args) {
		Powxn obj = new Powxn();
		System.out.println(obj.myPow(8.95371, -1));
	}

}
