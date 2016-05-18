package org.leetcode;

/*
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
public class ExcelSheetColumnNumber
{
	
	//Accepted solution with 3 ms runtime
    public int titleToNumber(String s)
    {
    	int num = 0;
    	if(s == null || s.isEmpty())
    		return num;
    	int power = 1;
    	int len = s.length();
    	for(int i = len-1; i >= 0 ; i--)
    	{
    		char ch = s.charAt(i);
    		int curVal = ch - 'A' + 1;
    		num += curVal*power;
    		power = power * 26;
    	}
        return num;
    }

	public static void main(String[] args)
	{
		ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
		System.out.println(obj.titleToNumber("A"));
		System.out.println(obj.titleToNumber("AA"));
	}

}
