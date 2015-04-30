package org.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestCode {
	public String largestNumber(int[] nums) {
        String numStr = "";
        int i = 0;
        int maxDigits = 0;
        Integer[] numArr = new Integer[nums.length];
        for(i = 0 ; i < nums.length ; i++){
        	numArr[i] = new Integer(Integer.valueOf(nums[i])); 
        	int curDigits = 0, curVal = nums[i];
        	while(curVal > 0){
        		curDigits++;
        		curVal = curVal/10;
        	}
        	if(curDigits > maxDigits)
        		maxDigits = curDigits;
        }
        for(int radix = 0 ; radix < maxDigits ; radix++){
        	Arrays.sort(numArr, new MyComparator(radix));
        }
        
        for(i = numArr.length-1 ; i >=0 ; i--){
        	numStr = numStr + "" + numArr[i].intValue();
        }
        //Get rid of the initial zeroes
        while(numStr.length()>0 && numStr.charAt(0)=='0'){
        	numStr = numStr.substring(1);
        }
        if(numStr == null || numStr.equals("")) numStr = "0";
        return numStr;
    }
	class MyComparator implements Comparator<Integer>{
		int i;
		MyComparator(int i){
			this.i = i;
		}
		@Override
		public int compare(Integer num1, Integer num2) {
			String str1 = num1+"";
			String str2 = num2+"";
			return (int)(Long.parseLong(str1+str2) - Long.parseLong(str2+str1));
		}
	}
	
	public static void main(String[] args) {
		int[] num = {0,0};
		LargestCode obj = new LargestCode();
		System.out.println(obj.largestNumber(num));
	}

}
