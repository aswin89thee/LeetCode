package org.leetcode;

public class ValidNumber {
	//Wrong solution
	public boolean isNumber(String s) {
		boolean isValid = true;
		if(s.equals(""))return true;
		//If all numbers, return true
		if(!validChars(s)) return false;
		//Check for decimal and e
		if(!eIsPlacedRight(s)) return false;
		return isValid;
	}
	private boolean eIsPlacedRight(String s) {
		int eCount = 0, eIndex = -1;
		int dotCount = 0, dotIndex = -1;
		for(int i = 0 ; i < s.length() ; i++){
			if(s.charAt(i) == 'e'){
				eIndex = i;
				++eCount;
			}
			if(s.charAt(i) == '.'){
				dotIndex = i;
				++dotCount;
			}
		}
		if(eCount > 1) return false;
		if(dotCount > 1) return false;
		if(eIndex == 0 || eIndex == s.length() -1 ) return false;
		if(dotIndex == 0 && s.length() == 1 ) return false;
		if(eCount > 0 && dotCount > 0 && eIndex < dotIndex) return false;
		return true;
	}
	private boolean validChars(String s) {
		int i;
		boolean validChar = true;
		for(i = 0 ; i < s.length() ; i++){
			char ch = s.charAt(i);
			if(ch >= 48 && ch <= 57){
				continue;
			}else{
				if(ch != '.' && ch != 'e' && ch != ' '){
					validChar = false;
					break;
				}
			}
		}
		return validChar;
	}

	public static void main(String[] args) {
		ValidNumber obj = new ValidNumber();
		String str = " ";
		System.out.println(str + " : " + obj.isNumber(str));
		str = "1234";
		System.out.println(str + " : " + obj.isNumber(str));
		str = "12e34";
		System.out.println(str + " : " + obj.isNumber(str));
		str = "12.34";
		System.out.println(str + " : " + obj.isNumber(str));
		str = "12.3e4";
		System.out.println(str + " : " + obj.isNumber(str));
		str = "1e2.34";
		System.out.println(str + " : " + obj.isNumber(str));
		str = ".1234";
		System.out.println(str + " : " + obj.isNumber(str));
		str = "1234.";
		System.out.println(str + " : " + obj.isNumber(str));
		str = "123a4";
		System.out.println(str + " : " + obj.isNumber(str));
	}

}
