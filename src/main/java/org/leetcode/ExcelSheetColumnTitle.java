package org.leetcode;

/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle
{
	//Accepted solution
	public String convertToTitle(int n)
	{
		String title = "";
		while(n > 0)
		{
			int m = n % 26;
			n = n/26;
			int ind = m == 0 ? 25 : m-1;
			title = (char)(65+ind) + title;
			if(m == 0)
				n--;
		}
        return title;
    }

	public static void main(String[] args)
	{
		ExcelSheetColumnTitle obj = new ExcelSheetColumnTitle();
		System.out.println(obj.convertToTitle(28));
	}

}
